package com.algorithm2024.programers07;

import java.util.ArrayList;
import java.util.List;

public class Example20241207_q1 {
    private final GridMatrix gridMatrix;
    private final PathValidator pathValidator;
    private final MatrixOperations matrixOps;

    public Example20241207_q1(int[][] grid) {
        this.gridMatrix = new GridMatrix(grid);
        this.pathValidator = new PathValidator();
        this.matrixOps = new MatrixOperations();
    }

    public int calculatePaths(int[] differences, int k) {
        int L = gridMatrix.getTotalSize();
        DynamicPathMatrix dynamicMatrix = new DynamicPathMatrix(L, differences.length);

        // DP 매트릭스 계산
        for (int d = 0; d < differences.length; d++) {
            calculateDynamicMatrix(dynamicMatrix, d, differences[d]);
        }

        // 최종 결과 계산
        return matrixOps.calculateFinalResult(dynamicMatrix.getFinalMatrix(), k, L);
    }

    private void calculateDynamicMatrix(DynamicPathMatrix dp, int currentStep, int difference) {
        for (GridPosition current : gridMatrix.getAllPositions()) {
            for (Direction dir : Direction.values()) {
                GridPosition next = current.move(dir);

                if (pathValidator.isValidMove(gridMatrix, current, next, difference)) {
                    dp.updateMatrix(currentStep, current.getLinearPosition(), next.getLinearPosition());
                }
            }
        }
    }
}

// 방향을 나타내는 열거형
enum Direction {
    UP(1, 0), DOWN(-1, 0), RIGHT(0, 1), LEFT(0, -1);

    final int dy;
    final int dx;

    Direction(int dy, int dx) {
        this.dy = dy;
        this.dx = dx;
    }
}

// 격자 위치를 표현하는 값 객체
class GridPosition {
    private final int row;
    private final int col;
    private final int totalCols;

    public GridPosition(int row, int col, int totalCols) {
        this.row = row;
        this.col = col;
        this.totalCols = totalCols;
    }

    public GridPosition move(Direction dir) {
        return new GridPosition(row + dir.dy, col + dir.dx, totalCols);
    }

    public int getLinearPosition() {
        return row * totalCols + col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}

// 격자 매트릭스를 관리하는 클래스
class GridMatrix {
    private final int[][] grid;
    private final int rows;
    private final int cols;

    public GridMatrix(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public List<GridPosition> getAllPositions() {
        List<GridPosition> positions = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                positions.add(new GridPosition(i, j, cols));
            }
        }
        return positions;
    }

    public int getValue(GridPosition pos) {
        return grid[pos.getRow()][pos.getCol()];
    }

    public boolean isInBounds(GridPosition pos) {
        return pos.getRow() >= 0 && pos.getRow() < rows &&
                pos.getCol() >= 0 && pos.getCol() < cols;
    }

    public int getTotalSize() {
        return rows * cols;
    }
}

// 경로 유효성을 검증하는 클래스
class PathValidator {
    public boolean isValidMove(GridMatrix grid, GridPosition current, GridPosition next, int expectedDiff) {
        if (!grid.isInBounds(next)) {
            return false;
        }
        return grid.getValue(next) - grid.getValue(current) == expectedDiff;
    }
}

// 동적 경로 매트릭스를 관리하는 클래스
class DynamicPathMatrix {
    private static final int MOD = 1000000007;
    private final int[][][] matrix;

    public DynamicPathMatrix(int size, int steps) {
        matrix = new int[steps + 1][size][size];
        initializeMatrix(size);
    }

    private void initializeMatrix(int size) {
        for (int i = 0; i < size; i++) {
            matrix[0][i][i] = 1;
        }
    }

    public void updateMatrix(int step, int from, int to) {
        for (int l = 0; l < matrix[0].length; l++) {
            matrix[step + 1][l][to] = (matrix[step + 1][l][to] + matrix[step][l][from]) % MOD;
        }
    }

    public int[][] getFinalMatrix() {
        return matrix[matrix.length - 1];
    }
}

// 매트릭스 연산을 담당하는 클래스
class MatrixOperations {
    private static final int MOD = 1000000007;

    public int calculateFinalResult(int[][] matrix, int k, int size) {
        int[][] result = matrixPower(matrix, k, size);
        return sumMatrix(result);
    }

    private int[][] matrixPower(int[][] A, int N, int L) {
        if (N == 1) return A;

        int[][] half = matrixPower(A, N / 2, L);
        int[][] result = multiply(half, half, L);

        return N % 2 == 0 ? result : multiply(result, A, L);
    }

    private int[][] multiply(int[][] A, int[][] B, int L) {
        int[][] result = new int[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                for (int k = 0; k < L; k++) {
                    result[i][j] = (result[i][j] + (int)(((long)A[i][k] * B[k][j]) % MOD)) % MOD;
                }
            }
        }
        return result;
    }

    private int sumMatrix(int[][] matrix) {
        long sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum = (sum + value) % MOD;
            }
        }
        return (int) sum;
    }
}