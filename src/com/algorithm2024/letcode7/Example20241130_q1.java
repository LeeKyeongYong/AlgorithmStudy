package com.algorithm2024.letcode7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20241130_q1 {
    static long[] sum;
    static final int MOD = 1000000007;

    public int[] solution(int[] a, int[] s) {
        int[] answer = new int[s.length];
        int idx = 0;

        for (int t = 0; t < s.length; t++) {
            int n = s[t];
            int start = idx;
            int end = start + n;
            idx = end;

            sum = new long[n + 1];
            sum[0] = 1;

            // 레벨 생성
            List<Map<Long, Integer>> levels = LevelFactory.createLevels(n);

            // 초기에 level[0]에 -1 넣기
            levels.get(0).put(-1L, -1);

            // DefaultCellConnectionStrategy 사용
            CellConnectionStrategy strategy = new DefaultCellConnectionStrategy();

            // sum 배열 채우기
            for (int i = 1; i <= n; i++) {
                sum[i] = strategy.connect(a[start + i - 1], i, i - 1, levels, sum);
            }

            answer[t] = (int) (sum[n] % MOD);
        }

        return answer;
    }
}

interface CellConnectionStrategy {
    long connect(long num, int here, int par, List<Map<Long, Integer>> levels, long[] sum);
}

class DefaultCellConnectionStrategy implements CellConnectionStrategy {
    static final int MOD = 1000000007;

    @Override
    public long connect(long num, int here, int par, List<Map<Long, Integer>> levels, long[] sum) {
        Map<Long, Integer> level = levels.get(here);

        if (!level.containsKey(num)) {
            level.put(num, par);
        }

        long ret = sum[par];

        if (levels.get(par).containsKey(num)) {
            ret += connect(num * 2, here, levels.get(par).get(num), levels, sum);
            ret %= MOD;
        }

        return ret;
    }
}

class LevelFactory {
    public static List<Map<Long, Integer>> createLevels(int n) {
        List<Map<Long, Integer>> levels = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            levels.add(new HashMap<>());
        }
        return levels;
    }
}
