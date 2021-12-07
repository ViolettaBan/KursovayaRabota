package by.vita02.backend.dto;

public class MatrixDTO {
    private final int[][] matrix;
    private final int n;
    private final int m;

    public MatrixDTO(int[][] matrix, int n, int m) {
        this.matrix = matrix;
        this.n = n;
        this.m = m;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}
