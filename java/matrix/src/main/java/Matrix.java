
class Matrix {

    int matrixLength;
    int matrixWidth;
    int[][] matrix;

    // initially split matrixAsString into an array of strings, 
    // each containing a string representation of a row of integers
    // Then, split that row. Proceed to populate array with the split row's values.
    Matrix(String matrixAsString) {
        String[] rowOfNumbers = matrixAsString.split("\n");

        this.matrixLength = matrixAsString.split("\n").length;
        // first row will have the same width as all others
        this.matrixWidth = rowOfNumbers[0].split(" ").length;

        this.matrix = new int[matrixLength][matrixWidth];
        
        for (int i = 0; i < matrixLength; i++) {
            String[] row = rowOfNumbers[i].split(" ");
            for (int j = 0; j < row.length; j++) {
                int value = Integer.parseInt(row[j]);
                matrix[i][j] = value;
            }
        }
    }


    // tests are 1 indexed
    int[] getRow(int rowNumber) {
        return this.matrix[rowNumber - 1];
    }

    // tests are 1 indexed
    // column's length is equal to the number of rows.
    // from each row, populate array column with data from row at index (columnNumber - 1)
    int[] getColumn(int columnNumber) {
        int column[] = new int[this.matrixLength];
        for (int i = 0; i < matrixLength; i++)
            column[i] = matrix[i][columnNumber - 1];

        return column;
    }
}
