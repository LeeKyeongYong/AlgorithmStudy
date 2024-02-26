package com.algorithm2024.programers01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam20240226_01 { //프로그래머스 이모티콘
    static final List<Integer> PERCENTAGE = List.of(10, 20, 30, 40);
    static int n;
    static int m;
    static List<int[]> answers;
    static int[] answer;

    public static int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        answers = new ArrayList<>();

        n = users.length;
        m = emoticons.length;

        permutation(0, emoticons, new int[emoticons.length], users);

        Collections.sort(answers, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }

            return o2[0] - o1[0];
        });

        return answers.get(0);
    }

    static void permutation(int index, int[] emoticons, int[] percentages, int[][] users) {
        if (index == m) {
            getAnswer(emoticons, percentages, users);
            return;
        }

        for (int p : PERCENTAGE) {
            percentages[index] = p;
            permutation(index + 1, emoticons, percentages, users);
        }
    }

    static void getAnswer(int[] emoticons, int[] percentages, int[][] users) {
        int membership = 0;
        int sellPrice = 0;

        for (int[] user : users) {
            int mustBuyPrice = 0;

            for (int i = 0; i < m; i++) {
                if (percentages[i] >= user[0]) {
                    mustBuyPrice += (int) (emoticons[i] * (100 - percentages[i]) * 0.01);
                }
            }

            if (mustBuyPrice >= user[1]) {
                membership++;
            } else {
                sellPrice += mustBuyPrice;
            }

            answers.add(new int[]{membership, sellPrice});
        }
    }

    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};

        // 4, 13860
        System.out.println(Arrays.toString(solution(users, emoticons)));
    }
}
