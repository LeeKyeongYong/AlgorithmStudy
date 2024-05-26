package com.algorithm2024.programers03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example20240526_01 { //프로그래머스 줄서는 방법
    static int[] arr;
    static List<List<Integer>> answer;
    static boolean[] visited;

    public static int[] solution(int n, long k) {
        arr = new int[n];
        answer = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permutation(0, n, k, new ArrayList<>());

        return answer.get((int) k - 1).stream()
                .mapToInt(i -> i)
                .toArray();
    }

    static void permutation(int index, int n, long k, List<Integer> list) {
        if (list.size() == n) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                permutation(index + 1, n, k, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // 3 1 2
        System.out.println(Arrays.toString(solution(3, 5)));
    }
}
