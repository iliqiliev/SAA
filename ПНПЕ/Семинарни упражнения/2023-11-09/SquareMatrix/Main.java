package SquareMatrix;

public class Main {
    public static void main(String[] args) {

        SquareMatrix matrix = new SquareMatrix(4);

        System.out.println("Initial matrix:");
        matrix.showMatrix();
        System.out.println();

        matrix = new SquareMatrix(4, "identity");

        System.out.println("Identity matrix:");
        matrix.showMatrix();
        System.out.println();

        matrix = new SquareMatrix(4, "random");

        System.out.println("Random matrix:");
        matrix.showMatrix();
        System.out.println();

        System.out.println("The main diagonal:\n" + matrix.mainDiagonal());
        System.out.println();

        System.out.println("The sum of the main diagonal: " + matrix.mainDiagonalSum());
        System.out.println();

        System.out.println("The sum of the antidiagonal: " + matrix.antidiagonalSum());
        System.out.println();

        System.out.println("The original matrix:");
        matrix.showMatrix();
        System.out.println();
        matrix.transpose();
        System.out.println("The transposed matrix:");
        matrix.showMatrix();

    }
}
