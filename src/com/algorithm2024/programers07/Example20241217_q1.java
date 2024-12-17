package com.algorithm2024.programers07;

public class Example20241217_q1 {
    public static int solution(int n, int count) {
        DPCalculator20241217 calculator = new DPCalculator20241217(n);
        return calculator.calculate(n, count);
    }
}

interface CalculationStrategy20241217 {
    long calculate(DPMatrix matrix, int x, int y);
}

class FirstColumnStrategy implements CalculationStrategy20241217 {
    @Override
    public long calculate(DPMatrix matrix, int x, int y) {
        return matrix.get(x - 1, y) * (2 * (x - 1));
    }
}

class MiddleColumnStrategy implements CalculationStrategy20241217 {
    @Override
    public long calculate(DPMatrix matrix, int x, int y) {
        return matrix.get(x - 1, y) * (2 * (x - 1)) + matrix.get(x - 1, y - 1);
    }
}

class LastColumnStrategy implements CalculationStrategy20241217 {
    @Override
    public long calculate(DPMatrix matrix, int x, int y) {
        return matrix.get(x - 1, y - 1);
    }
}

class DPMatrix {
    private final long[][] matrix;
    private final long MOD = 1000000007;

    public DPMatrix(int n) {
        this.matrix = new long[n + 1][n + 2];
        matrix[1][1] = 1;
    }

    public long get(int x, int y) {
        return matrix[x][y];
    }

    public void set(int x, int y, long value) {
        matrix[x][y] = value % MOD;
    }

    public long getMOD() {
        return MOD;
    }
}

class DPCalculator20241217 {
    private final DPMatrix matrix;
    private final CalculationStrategy20241217 firstColumnStrategy;
    private final CalculationStrategy20241217 middleColumnStrategy;
    private final CalculationStrategy20241217 lastColumnStrategy;

    public DPCalculator20241217(int n) {
        this.matrix = new DPMatrix(n);
        this.firstColumnStrategy = new FirstColumnStrategy();
        this.middleColumnStrategy = new MiddleColumnStrategy();
        this.lastColumnStrategy = new LastColumnStrategy();
    }

    public int calculate(int n, int count) {
        for (int x = 2; x <= n; x++) {
            for (int y = 1; y <= x + 1; y++) {
                CalculationStrategy20241217 strategy = getStrategy(x, y);
                long result = strategy.calculate(matrix, x, y);
                matrix.set(x, y, result);
            }
        }
        return (int) (matrix.get(n, count) % matrix.getMOD());
    }

    private CalculationStrategy20241217 getStrategy(int x, int y) {
        if (y == 1) {
            return firstColumnStrategy;
        } else if (y > 1 && y <= x) {
            return middleColumnStrategy;
        } else {
            return lastColumnStrategy;
        }
    }
}