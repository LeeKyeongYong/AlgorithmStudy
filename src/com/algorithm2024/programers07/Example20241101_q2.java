package com.algorithm2024.programers07;

public class Example20241101_q2 {

    static int answer;
    static int n;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        n = words.length;
        visited = new boolean[n];

        dfs(0, begin, target, words);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    static void dfs(int index, String now, String target, String[] words) {
        if (now.equals(target)) {
            answer = Math.min(answer, index);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            String word = words[i];

            int diff = 0;
            for (int j = 0; j < now.length(); j++) {
                if (word.charAt(j) != now.charAt(j)) {
                    diff++;
                }
            }

            if (diff != 1) {
                continue;
            }

            visited[i] = true;
            dfs(index + 1, word, target, words);
            visited[i] = false;
        }
    }

}
