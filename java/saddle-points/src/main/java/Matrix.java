import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Matrix {

    private List<List<Integer>> matrix;

    public Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    public Set<MatrixCoordinate> getSaddlePoints() {
        List<Integer> rowMaxValues = getRowMaxValues();
        List<Integer> colMinValues = getColMinValues();
    
        return IntStream.range(0, matrix.size())
                .boxed()
                .flatMap(rowIndex -> IntStream.range(0, matrix.get(0).size())
                        .mapToObj(colIndex -> {
                            int currentRowMax = rowMaxValues.get(rowIndex);
                            int currentColMin = colMinValues.get(colIndex);
                            if (currentRowMax == currentColMin)
                                return new MatrixCoordinate(rowIndex + 1, colIndex + 1);
    
                            return null;
                        }))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
    

    private List<Integer> getRowMaxValues() {
        return matrix.stream().map(row -> getRowMax(row)).collect(Collectors.toList());
    }

    private List<Integer> getColMinValues() {
        if (matrix.isEmpty())
            return Collections.emptyList();

        return IntStream.range(0, matrix.get(0).size())
                .mapToObj(colIndex -> getColumn(colIndex))
                .mapToInt(this::getColMin)
                .boxed()
                .collect(Collectors.toList());
    }

    private int getRowMax(List<Integer> row) {
        return row.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
    }

    private List<Integer> getColumn(int colNumber) {
        return matrix.stream().map(row -> row.get(colNumber)).collect(Collectors.toList());
    }

    private int getColMin(List<Integer> col) {
        return col.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);
    }

}
