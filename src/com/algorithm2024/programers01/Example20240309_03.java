package com.algorithm2024.programers01;

public class Example20240309_03 {//프로그래머스 단체 사진 찍기
    static final String[] CHARACTERS = {"A", "C", "F", "J", "M", "N", "R", "T"};

    static int k;
    static int answer;
    static boolean[] visited;

    public static int solution(int n, String[] data) {
        answer = 0;
        k = CHARACTERS.length;
        visited = new boolean[k];

        permutation(0, "", data);

        return answer;
    }

    static void permutation(int index, String sum, String[] data) {
        if (index == CHARACTERS.length) {
            for (String d : data) {
                char left = d.charAt(0);
                char right = d.charAt(2);
                char op = d.charAt(3);
                int gap = d.charAt(4) - '0';

                int leftIndex = sum.indexOf(left);
                int rightIndex = sum.indexOf(right);

                int abs = Math.abs(leftIndex - rightIndex) - 1;

                if (op == '=') {
                    if (abs != gap) {
                        return;
                    }
                } else if (op == '>') {
                    if (abs <= gap) {
                        return;
                    }
                } else if (op == '<') {
                    if (abs >= gap) {
                        return;
                    }
                }
            }

            answer++;
            return;
        }

        for (int i = 0; i < k; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            permutation(index + 1, sum + CHARACTERS[i], data);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        // 3648
        System.out.println(solution(n, data));
    }
}
