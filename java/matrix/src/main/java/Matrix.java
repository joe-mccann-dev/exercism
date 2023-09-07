
class Matrix {

    int matrixLength;
    int matrixWidth;
    int[][] matrix;

    // initially split matrixAsString into an array of strings, 
    // each containing a string representation of a row of integers
    // Then, split that row. Proceed to populate array with the split row's values.
    Matrix(String matrixAsString) {
        String[] numbers = matrixAsString.split("\n");

        this.matrixLength = matrixAsString.split("\n").length;
        // first row will have the same width as all others
        this.matrixWidth = numbers[0].split(" ").length;

        this.matrix = new int[matrixLength][matrixWidth];
        
        for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
            String[] row = numbers[rowIndex].split(" ");
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                int value = Integer.parseInt(row[columnIndex]);
                matrix[rowIndex][columnIndex] = value;
            }
        }
    }


    // tests are 1 indexed
    int[] getRow(int rowNumber) {
        return this.matrix[rowNumber - 1];
    }

    // tests are 1 indexed
    // column's length is equal to the number of rows.
    // from each row, populate array column with data from row at index[columnNumber - 1]
    int[] getColumn(int columnNumber) {
        int column[] = new int[matrixLength];
        for (int i = 0; i < matrixLength; i++)
            column[i] = matrix[i][columnNumber - 1];

        return column;
    }
}
