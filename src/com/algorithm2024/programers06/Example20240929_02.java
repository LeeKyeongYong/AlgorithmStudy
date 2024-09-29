package com.algorithm2024.programers06;

public class Example20240929_02 {
    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        permutation(0, k, dungeons);
        return answer;
    }

    static void permutation(int index, int nowPirodo, int[][] dungeons) {
        answer = Math.max(answer, index);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && nowPirodo >= dungeons[i][0]) {
                visited[i] = true;
                nowPirodo -= dungeons[i][1];
                permutation(index + 1, nowPirodo, dungeons);
                nowPirodo += dungeons[i][1];
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Example20240929_02 sol = new Example20240929_02();

        // 3
        System.out.println((sol.solution(
                80,
                new int[][]{{80, 20}, {50, 40}, {30, 10}}
        )));
    }
}
