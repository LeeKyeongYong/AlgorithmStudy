package com.algorithm2024.programers07;


import java.util.Arrays;

public class Example20241219_q1 {
    private static final int MODULO = 10000019; // 모듈러 상수 통합

    public int Example20241219_q1(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;

        CombinationCalculator combinationCalc = new CombinationCalculator(rows);
        OneCntCalculator oneCntCalc = new OneCntCalculator(a);
        DPCalculator dpCalc = new DPCalculator(rows, cols, combinationCalc, oneCntCalc);

        return dpCalc.calculate();
    }

    // 조합 계산 클래스
    private static class CombinationCalculator {
        private final long[][] nCr;

        public CombinationCalculator(int maxN) {
            nCr = new long[maxN + 1][maxN + 1];
            calculateCombinations(maxN);
        }

        private void calculateCombinations(int maxN) {
            nCr[0][0] = 1;
            for (int i = 1; i <= maxN; i++) {
                nCr[i][0] = nCr[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MODULO;
                }
            }
        }

        public long get(int n, int r) {
            return nCr[n][r];
        }
    }

    // 각 열의 1의 개수 계산 클래스
    private static class OneCntCalculator {
        private final int[] oneCnt;

        public OneCntCalculator(int[][] map) {
            oneCnt = new int[map[0].length];
            calculateOneCnt(map);
        }

        private void calculateOneCnt(int[][] map) {
            for (int[] row : map) {
                for (int j = 0; j < row.length; j++) {
                    oneCnt[j] += row[j];
                }
            }
        }

        public int get(int index) {
            return oneCnt[index];
        }
    }

    // DP 계산 클래스
    private static class DPCalculator {
        private final int rows;
        private final int cols;
        private final CombinationCalculator combinationCalc;
        private final OneCntCalculator oneCntCalc;
        private long[][] dp; // 현재와 이전 상태만 유지

        public DPCalculator(int rows, int cols, CombinationCalculator combinationCalc, OneCntCalculator oneCntCalc) {
            this.rows = rows;
            this.cols = cols;
            this.combinationCalc = combinationCalc;
            this.oneCntCalc = oneCntCalc;
            this.dp = new long[2][rows + 1];
        }

        public int calculate() {
            dp[0][rows - oneCntCalc.get(0)] = combinationCalc.get(rows, rows - oneCntCalc.get(0));

            for (int col = 1; col < cols; col++) {
                int oneCnt = oneCntCalc.get(col);
                Arrays.fill(dp[col % 2], 0); // 현재 상태 초기화

                for (int evenNum = 0; evenNum <= rows; evenNum++) {
                    if (dp[(col - 1) % 2][evenNum] == 0) continue;

                    for (int k = 0; k <= oneCnt && k <= evenNum; k++) {
                        int beEvenRow = evenNum + oneCnt - (2 * k);
                        if (beEvenRow > rows) continue;

                        long result = (combinationCalc.get(evenNum, k) * combinationCalc.get(rows - evenNum, oneCnt - k)) % MODULO;
                        dp[col % 2][beEvenRow] = (dp[col % 2][beEvenRow] + dp[(col - 1) % 2][evenNum] * result) % MODULO;
                    }
                }
            }

            return (int) dp[(cols - 1) % 2][rows];
        }
    }
}
