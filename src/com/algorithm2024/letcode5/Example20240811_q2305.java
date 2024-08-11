package com.algorithm2024.letcode5;

public class Example20240811_q2305 {

    static int answer;

    public int distributeCookies(int[] cookies, int k) {
        answer = Integer.MAX_VALUE;
        dfs(0, cookies, k, new int[k]);
        return answer;
    }

    private void dfs(int index, int[] cookies, int k, int[] arr) {
        if (index == cookies.length) {
            int max = Integer.MIN_VALUE;
            for (int i : arr) {
                max = Math.max(max, i);
            }
            answer = Math.min(max, answer);
            return;
        }

        for (int i = 0; i < k; i++) {
            arr[i] += cookies[index];
            dfs(index + 1, cookies, k, arr);
            arr[i] -= cookies[index];
        }
    }

    public static void main(String[] args) {
        Example20240811_q2305 sol = new Example20240811_q2305();

        int[] cookies = {6, 1, 3, 2, 2, 4, 1, 2};
        int k = 3;

        // 7
        System.out.println(sol.distributeCookies(cookies, k));
    }

}
