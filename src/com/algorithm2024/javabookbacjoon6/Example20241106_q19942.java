package com.algorithm2024.javabookbacjoon6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20241106_q19942 {

    static int n;
    static int[][] map;
    static int[] target;
    static int answer;
    static List<Integer> choiceAnswer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][5];
        target = new int[4];
        answer = Integer.MAX_VALUE;
        choiceAnswer = new ArrayList<>();

        target = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

        for (int i = 0; i < n; i++) {
            map[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        permutation(0, new int[5], new ArrayList<>());

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
        StringBuilder sb = new StringBuilder();
        for (Integer i : choiceAnswer) {
            sb.append((i + 1) + " ");
        }
        System.out.println(sb.toString());
    }

    static void permutation(int start, int[] now, List<Integer> choices) {
        boolean isDone = true;
        for (int i = 0; i < target.length; i++) {
            if (now[i] < target[i]) {
                isDone = false;
                break;
            }
        }

        if (isDone) {
            if (answer > now[4]) {
                answer = now[4];
                choiceAnswer = new ArrayList<>(choices);
            }
            return;
        }

        for (int i = start; i < map.length; i++) {
            for (int j = 0; j < 5; j++) {
                now[j] += map[i][j];
            }
            choices.add(i);
            permutation(i + 1, now, choices);
            choices.remove(choices.size() - 1);

            for (int j = 0; j < map[i].length; j++) {
                now[j] -= map[i][j];
            }
        }
    }

}
