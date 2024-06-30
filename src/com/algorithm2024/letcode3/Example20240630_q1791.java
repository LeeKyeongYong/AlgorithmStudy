package com.algorithm2024.letcode3;

import java.util.*;

public class Example20240630_q1791 {

    public static int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        System.out.println(map);

        int answer = 0;
        int max = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (max < entry.getValue().size()) {
                answer = entry.getKey();
                max = entry.getValue().size();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 2
        System.out.println(findCenter(
                new int[][]{{1, 2}, {2, 3}, {4, 2}}
        ));
    }

}
