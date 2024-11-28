package com.algorithm2024.programers07;

import java.util.*;

public class Example20241128_q1 { //월간 코드 챌린지 시즌3  안티세포 복습

    static class CellConnector {
        private final List<Map<Long, Integer>> levels;
        private final long[] sum;
        private static final int MOD = 1000000007;

        public CellConnector(int n) {
            this.levels = new ArrayList<>(n + 1);
            this.sum = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                levels.add(new HashMap<>());
            }
            sum[0] = 1; // 초기화
        }

        public long connect(long num, int here, int par) {
            Map<Long, Integer> currentLevel = levels.get(here);
            if (!currentLevel.containsKey(num)) {
                currentLevel.put(num, par);
            }

            long ret = sum[par];

            if (levels.get(par).containsKey(num)) {
                ret += connect(num * 2, here, levels.get(par).get(num));
                ret %= MOD;
            }

            return ret;
        }

        public void initializeFirstLevel() {
            levels.get(0).put(-1L, -1);
        }

        public void setSum(int level, long value) {
            sum[level] = value;
        }

        public long getSum(int level) {
            return sum[level];
        }
    }

    public int[] solution(int[] a, int[] s) {
        int[] answer = new int[s.length];
        int idx = 0;
        int start, end = 0;

        for (int t = 0; t < s.length; t++) {
            int n = s[t];
            start = end;
            end = start + n;

            CellConnector connector = new CellConnector(n);
            connector.initializeFirstLevel();

            for (int i = 1; i <= n; i++) {
                long cellValue = a[start + i - 1];
                long sumValue = connector.connect(cellValue, i, i - 1);
                connector.setSum(i, sumValue);
            }

            answer[t] = (int) (connector.getSum(n) % CellConnector.MOD);
        }

        return answer;
    }
}
