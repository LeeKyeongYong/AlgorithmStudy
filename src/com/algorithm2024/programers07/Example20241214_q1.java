package com.algorithm2024.programers07;


class MatrixContext {
    private static MatrixContext instance;
    private final int[][] matrix;
    private final int row;
    private final int col;

    private MatrixContext(int[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
    }

    public static MatrixContext getInstance(int[][] matrix) {
        if (instance == null) {
            instance = new MatrixContext(matrix);
        }
        return instance;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}

public class Example20241214_q1 {
    private static final int MODULAR = 10000019;

    public int solution(int[][] a) {
        // Initialize context
        MatrixContext context = MatrixContext.getInstance(a);
        int row = context.getRow();
        int col = context.getCol();

        // Initialize data structures
        long[][] combinations = new long[row + 1][row + 1];
        int[] oneCounts = new int[col + 1];
        long[][] dp = new long[col + 2][row + 1];

        // Calculate combinations
        CalculationStrategy combCalc = new CombinationCalculator(combinations, row);
        combCalc.calculate();

        // Calculate one counts
        CalculationStrategy oneCalc = new OneCountCalculator(oneCounts, a);
        oneCalc.calculate();

        // Calculate dynamic programming solution
        DPCalculator dpCalc = new DPCalculator(dp, oneCounts, combinations, row, col);
        dpCalc.calculate();

        return (int)dp[col][row];
    }
}

interface CalculationStrategy {
    void calculate();
}

// Combination Calculator using Strategy Pattern
class CombinationCalculator implements CalculationStrategy {
    private final long[][] combinations;
    private final int row;
    private static final int MODULAR = 10000019;

    public CombinationCalculator(long[][] combinations, int row) {
        this.combinations = combinations;
        this.row = row;
    }

    @Override
    public void calculate() {
        combinations[0][0] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <= row; j++) {
                if (j == 0 || i == j) {
                    combinations[i][j] = 1;
                } else {
                    combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MODULAR;
                }
            }
        }
    }
}

// One Count Calculator using Strategy Pattern
class OneCountCalculator implements CalculationStrategy {
    private final int[] counts;
    private final int[][] matrix;

    public OneCountCalculator(int[] counts, int[][] matrix) {
        this.counts = counts;
        this.matrix = matrix;
    }

    @Override
    public void calculate() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                counts[j] += matrix[i][j];
            }
        }
    }
}

// Dynamic Programming Calculator using Strategy Pattern
class DPCalculator {
    private static final int MODULAR = 10000019;
    private final long[][] dp;
    private final int[] oneCounts;
    private final long[][] combinations;
    private final int row;
    private final int col;

    public DPCalculator(long[][] dp, int[] oneCounts, long[][] combinations, int row, int col) {
        this.dp = dp;
        this.oneCounts = oneCounts;
        this.combinations = combinations;
        this.row = row;
        this.col = col;
    }

    public void calculate() {
        dp[1][row - oneCounts[0]] = combinations[row][row - oneCounts[0]];

        for (int column = 1; column < col; column++) {
            calculateForColumn(column);
        }
    }

    private void calculateForColumn(int column) {
        int oneCount = oneCounts[column];
        for (int evenNum = 0; evenNum <= row; evenNum++) {
            if (dp[column][evenNum] == 0) continue;

            calculateForEvenNum(column, oneCount, evenNum);
        }
    }

    private void calculateForEvenNum(int column, int oneCount, int evenNum) {
        for (int k = 0; k <= oneCount; k++) {
            if (evenNum < k) continue;

            int beEvenRow = evenNum + oneCount - (2 * k);
            if (beEvenRow > row) continue;

            long result = (combinations[evenNum][k] * combinations[row - evenNum][oneCount - k]) % MODULAR;
            dp[column + 1][beEvenRow] = (dp[column + 1][beEvenRow] + dp[column][evenNum] * result) % MODULAR;
        }
    }
}