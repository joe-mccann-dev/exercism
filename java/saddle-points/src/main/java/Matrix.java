import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Matrix {

    List<List<Integer>> matrix;

    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> result = new HashSet<>();
        if (matrix.isEmpty())
            return result;
            
        List<Integer> rowMaxValues = matrix.stream()
                .map(row -> getRowMax(row))
                .collect(Collectors.toList());

        List<Integer> colMinValues = IntStream.range(0, matrix.get(0).size())
                .mapToObj(colIndex -> getColumn(colIndex))
                .mapToInt(this::getColMin)
                .boxed()
                .collect(Collectors.toList());

        for (int rowIndex = 0; rowIndex < matrix.size(); rowIndex++) {
            int currentRowMax = rowMaxValues.get(rowIndex);
            for (int colIndex = 0; colIndex < matrix.get(0).size(); colIndex++) {
                int currentColMin = colMinValues.get(colIndex);
                if (currentRowMax == currentColMin) {
                    MatrixCoordinate saddlePoint = new MatrixCoordinate(rowIndex + 1, colIndex + 1);
                    result.add(saddlePoint);
                }
            }
        }

        return result;
    }

    List<Integer> getRow(int rowNumber) {
        return this.matrix.get(rowNumber);
    }

    List<Integer> getColumn(int colNumber) {
        return matrix.stream().map(row -> row.get(colNumber)).collect(Collectors.toList());
    }

    private int getRowMax(List<Integer> row) {
        return row.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
    }

    private int getColMin(List<Integer> col) {
        return col.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);
    }

}
