package com.algorithm2025.backjoon2.day013;

public class Example20250324_Q68647 { //코딩테스트 연습 월간 코드 챌린지 시즌1 짝수 행 세기
    static final int MOD = 10000019;

    // 파스칼 삼각형을 이용해 nCr(조합)을 미리 계산
    public static void computeCombinations(long[][] comb, int n) {
        comb[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
    }

    // 각 열의 1의 개수를 세어 배열에 저장
    public static int[] countOnesPerColumn(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[] onesCount = new int[colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                onesCount[j] += matrix[i][j];
            }
        }
        return onesCount;
    }

    public int Example20250324_Q68647(int[][] a) {
        int rowCount = a.length;
        int colCount = a[0].length;

        // 조합 계산: comb[i][j] = iCj
        long[][] comb = new long[rowCount + 1][rowCount + 1];
        computeCombinations(comb, rowCount);

        // 각 열별 1의 개수
        int[] onesCount = countOnesPerColumn(a);

        // dp[c][e]: 첫 c개의 열을 고려했을 때, e개의 행이 짝수(1이 짝수번 등장)인 경우의 수
        // dp 배열은 1-indexed로 사용하기 위해 colCount+2 크기로 할당
        long[][] dp = new long[colCount + 2][rowCount + 1];

        // 초기값: 첫 번째 열 (인덱스 0)
        int initEvenCount = rowCount - onesCount[0];
        dp[1][initEvenCount] = comb[rowCount][initEvenCount];

        // 각 열을 순차적으로 처리
        for (int col = 1; col < colCount; col++) {
            int ones = onesCount[col];
            for (int evenCount = 0; evenCount <= rowCount; evenCount++) {
                if (dp[col][evenCount] == 0) continue;
                // 현재 열에서 선택할 1의 개수를 k개 선택한다고 할 때
                for (int k = 0; k <= ones; k++) {
                    if (evenCount < k) continue;  // 짝수 행의 수가 부족하면 패스
                    // k개를 기존 짝수 행에서 1이 반전되어 홀수가 되고, 나머지(ones-k)는 홀수 행에서 반전되어 짝수가 됨
                    int nextEvenCount = evenCount + ones - 2 * k;
                    if (nextEvenCount > rowCount) continue;
                    long ways = (comb[evenCount][k] * comb[rowCount - evenCount][ones - k]) % MOD;
                    dp[col + 1][nextEvenCount] = (dp[col + 1][nextEvenCount] + dp[col][evenCount] * ways) % MOD;
                }
            }
        }
        return (int) dp[colCount][rowCount];
    }

}
