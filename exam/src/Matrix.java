public class Matrix {
    private int rows;
    private int columns;
    private int[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getValue(int row, int column) {
        return data[row][column];
    }

    public void setValue(int row, int column, int value) {
        data[row][column] = value;
    }

    public void add(Matrix other) {
        if (rows != other.getRows() || columns != other.getColumns()) {
            throw new IllegalArgumentException("Matrix dimensions must match.");
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] += other.getValue(i, j);
            }
        }
    }

    public Matrix multiply(Matrix other) {
        if (columns != other.getRows()) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
        }

        Matrix result = new Matrix(rows, other.getColumns());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                int sum = 0;
                for (int k = 0; k < columns; k++) {
                    sum += data[i][k] * other.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }

        return result;
    }
}
