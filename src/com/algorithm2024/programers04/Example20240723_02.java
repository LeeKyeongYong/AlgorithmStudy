package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240723_02 { //월간 코드 챌린지 시즌3 안티세포

    static List<Map<Long, Integer>> levels;
    static long sum[];
    static final int MOD = 1000000007;

    public int[] solution(int[] a, int[] s) {
        int[] answer = new int[s.length];
        int idx = 0;

        int start, end = 0;
        for(int t = 0; t < s.length; t++){
            int n = s[t];
            start = end;
            end = start + n;
            sum = new long[n+1];
            sum[0] = 1;

            //세포 개수 + 1 만큼 level
            //각 level에는 세포 크기가 key이고 세포 왼쪽 인덱스가 value인 맵
            levels = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                levels.add(new HashMap<>());
            }

            levels.get(0).put(new Long(-1),-1);

            for(int i = 1; i <= n; i++){
                sum[i] = connect(a[start + i - 1], i, i-1);
            }

            answer[t] = (int) ((sum[n])%MOD);
        }

        return answer;
    }

    //par level을 살펴보고 세포크기=num와 같은 세포 있으면 재귀적으로 호출. here = 현재 level
    static long connect(long num, int here, int par){
        Map<Long,Integer> level = levels.get(here);
        if(!level.containsKey(num)){
            level.put(num, par);
        }

        long ret = sum[par];

        if(levels.get(par).containsKey(num)){
            ret += connect(num * 2, here, levels.get(par).get(num));
            ret %= MOD;
        }

        return ret;
    }

}
