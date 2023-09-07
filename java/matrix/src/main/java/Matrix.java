
class Matrix {

    int matrixLength;
    int matrixWidth;
    int[][] matrix;

    Matrix(String matrixAsString) {
        // split into string array like => ["1 2 3", "4 5 6"];
        String[] numbers = matrixAsString.split("\n");

        this.matrixLength = numbers.length;
        this.matrixWidth = numbers[0].split("\\s").length;
        this.matrix = new int[matrixLength][matrixWidth];
        
        for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
            // split each row into its own row => ["1", "2", "3"];
            String[] row = numbers[rowIndex].split("\\s");
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                // populate matrix with parsed integer values
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
