public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 3);
        matrix1.setValue(0, 0, 1);
        matrix1.setValue(0, 1, 2);
        matrix1.setValue(0, 2, 3);
        matrix1.setValue(1, 0, 4);
        matrix1.setValue(1, 1, 5);
        matrix1.setValue(1, 2, 6);

        Matrix matrix2 = new Matrix(3, 2);
        matrix2.setValue(0, 0, 7);
        matrix2.setValue(0, 1, 8);
        matrix2.setValue(1, 0, 9);
        matrix2.setValue(1, 1, 10);
        matrix2.setValue(2, 0, 11);
        matrix2.setValue(2, 1, 12);

        matrix1.add(matrix2);

        System.out.println("Result of addition:");
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                System.out.print(matrix1.getValue(i, j) + " ");
            }
            System.out.println();
        }

        Matrix matrix3 = new Matrix(2, 2);
        matrix3.setValue(0, 0, 1);
        matrix3.setValue(0, 1, 2);
        matrix3.setValue(1, 0, 3);
        matrix3.setValue(1, 1, 4);

        Matrix matrix4 = new Matrix(2, 2);
        matrix4.setValue(0, 0, 5);
        matrix4.setValue(0, 1, 6);
        matrix4.setValue(1, 0, 7);
        matrix4.setValue(1, 1, 8);

        Matrix result = matrix3.multiply(matrix4);

        System.out.println("Result of multiplication:");
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                System.out.print(result.getValue(i, j) + " ");
            }
            System.out.println();
        }
    }
}