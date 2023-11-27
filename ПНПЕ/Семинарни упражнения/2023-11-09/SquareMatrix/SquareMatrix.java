package SquareMatrix;

import java.util.Random;

public class SquareMatrix {

    private int[][] matrix;
    private static Random random = new Random();

    public SquareMatrix(int size) {
        this.matrix = new int[size][size];
    }

    public SquareMatrix(int size, String matrixType) {
        this(size);

        switch (matrixType) {
            case "random":
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        this.matrix[row][col] = random.nextInt(10, 100);
                    }
                }
                break;
            case "identity":
                for (int i = 0; i < size; i++) {
                    this.matrix[i][i] = 1;
                }
                break;
            default:
                break;
        }
    }

    String mainDiagonal() {
        StringBuilder diagonal_elements = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            diagonal_elements.append(this.matrix[i][i] + " ");
        }
        return diagonal_elements.toString().trim();
    }

    int mainDiagonalSum() {
        int diagonal_sum = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            diagonal_sum += this.matrix[i][i];
        }
        return diagonal_sum;
    }

    int antidiagonalSum() {
        int antidiagonal_sum = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            antidiagonal_sum += this.matrix[i][this.matrix.length - i - 1];
        }
        return antidiagonal_sum;
    }

    void transpose() {
        for (int row = 0; row < this.matrix.length; row++) {
            for (int col = (row + 1); col < this.matrix.length; col++) {
                int temp = this.matrix[row][col];
                this.matrix[row][col] = this.matrix[col][row];
                this.matrix[col][row] = temp;
            }
        }
    }

    void showMatrix() {
        for (int row = 0; row < this.matrix.length; row++) {
            System.out.print("[");
            for (int col = 0; col < this.matrix.length; col++) {
                System.out.print(this.matrix[row][col]);
                if (col < this.matrix.length - 1)
                    System.out.print(" ");
            }
            System.out.print("]\n");
        }
    }

}
