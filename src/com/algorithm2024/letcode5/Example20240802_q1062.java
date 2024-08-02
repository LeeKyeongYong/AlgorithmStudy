package com.algorithm2024.letcode5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20240802_q1062 { //문자열 필터링 + 백트래킹으로 조합 찾기

    static int n;
    static int m;
    static int answer;
    static List<String> guess;
    static List<String> alphabet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a n t i c

        n = sc.nextInt();
        m = sc.nextInt();
        answer = 0;
        guess = new ArrayList<>();
        alphabet = new ArrayList<>();

        if (m <= 5) {
            System.out.println(0);
            return;
        } else if (m == 26) {
            System.out.println(n);
            return;
        }

        m -= 5;
        List<String> temp = List.of("a", "n", "t", "i", "c");
        for (int i = 0; i < n; i++) {
            String guessWord = sc.next()
                    .replaceAll("anta", "")
                    .replaceAll("tica", "");


            for (String s : temp) {
                if (guessWord.contains(s)) {
                    guessWord = guessWord.replaceAll(s, "");
                }
            }

            if (guessWord.isBlank()) {
                answer++;
                continue;
            }

            guess.add(guessWord);
            for (char c : guessWord.toCharArray()) {
                if (!alphabet.contains(c + "") && !temp.contains(c + "")) {
                    alphabet.add(c + "");
                }
            }
        }


        permutation(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    static void permutation(int index, int start, List<String> choice) {
        if (index == m || index == alphabet.size()) {
            int max = 0;

            for (String target : guess) {
                boolean isGood = true;

                for (char wordOfTarget : target.toCharArray()) {
                    if (!choice.contains(wordOfTarget + "")) {
                        isGood = false;
                        break;
                    }
                }

                if (isGood) {
                    max++;
                }
            }

            answer = Math.max(answer, max);
        }

        for (int i = start; i < alphabet.size(); i++) {
            choice.add(alphabet.get(i));
            permutation(index + 1, i + 1, choice);
            choice.remove(alphabet.get(i));
        }
    }

}
