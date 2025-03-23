package com.algorithm2025.backjoon2.day012;

public class Example20250322_Q68647 { //코딩테스트 연습 월간 코드 챌린지 시즌1 짝수 행 세기


    static final int MODULER = 10000019;

    // 조합 미리 계산
    public void precomputeCombinations(long[][] nCr, int row) {
        nCr[0][0] = 1;
        for (int i = 1; i <= row; i++) {
            nCr[i][0] = nCr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MODULER;
            }
        }
    }

    // 각 열의 1 개수 카운트
    public void countColumnOnes(int[] oneCount, int[][] map) {
        int rowLen = map.length;
        int colLen = map[0].length;
        for (int col = 0; col < colLen; col++) {
            for (int row = 0; row < rowLen; row++) {
                oneCount[col] += map[row][col];
            }
        }
    }

    public int Example20250322_Q68647(int[][] a) {
        int row = a.length;
        int col = a[0].length;

        long[][] nCr = new long[row + 1][row + 1];
        precomputeCombinations(nCr, row);

        int[] oneCount = new int[col];
        countColumnOnes(oneCount, a);

        long[][] dp = new long[col + 1][row + 1];
        dp[1][row - oneCount[0]] = nCr[row][row - oneCount[0]];

        for (int column = 1; column < col; column++) {
            int ones = oneCount[column];

            for (int evenNum = 0; evenNum <= row; evenNum++) {
                if (dp[column][evenNum] == 0) continue;

                int remaining = row - evenNum;
                for (int k = 0; k <= ones; k++) {
                    if (evenNum < k) continue;

                    int nextEvenNum = evenNum + ones - (2 * k);
                    if (nextEvenNum > row) continue;

                    long result = (nCr[evenNum][k] * nCr[remaining][ones - k]) % MODULER;
                    dp[column + 1][nextEvenNum] = (dp[column + 1][nextEvenNum] + dp[column][evenNum] * result) % MODULER;
                }
            }
        }
        return (int) dp[col][row];
    }

}
