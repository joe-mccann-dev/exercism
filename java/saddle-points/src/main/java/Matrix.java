import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {

    List<List<Integer>> matrix;

    Matrix(List<List<Integer>> values) {
        this.matrix = values;
    }

    // get row data
    // get column data
    // find num that is largest in its row and smallest in column
    // if those numbers are equal, add indices to result
    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> result = new HashSet<>();
        if (matrix.isEmpty())
            return result;

        
        List<Integer> row;
        List<Integer> col;
        int rowMax;
        int colMin;
        int rowLength = this.matrix.get(0).size();
        
        for (int rowIndex = 0; rowIndex < matrix.size(); rowIndex++) {
            for (int colIndex = 0; colIndex < rowLength; colIndex++) {
                row = getRow(rowIndex);
                col = getColumn(colIndex);
                rowMax = getRowMax(row);
                colMin = getColMin(col);
                if (rowMax == colMin) {
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
        List<Integer> column = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < this.matrix.size(); rowIndex++) {
            int columnInteger = this.matrix.get(rowIndex).get(colNumber);
            column.add(rowIndex, columnInteger);
        }

        return column;
    }

    private int getRowMax(List<Integer> row) {
        int rowMax = Integer.MIN_VALUE;
        int current = 0;
        for (int value : row) {
            current = value;
            rowMax = current > rowMax ? current : rowMax;
        }
        return rowMax;
    }

    private int getColMin(List<Integer> col) {
        int colMin = Integer.MAX_VALUE;
        int current = 0;
        for (int value : col) {
            current = value;
            colMin = current < colMin ? current : colMin;
        }

        return colMin;
    }

}
