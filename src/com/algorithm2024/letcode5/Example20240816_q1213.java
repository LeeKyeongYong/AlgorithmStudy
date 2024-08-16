package com.algorithm2024.letcode5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Example20240816_q1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String answer;

        if (s.length() % 2 == 0) {
            answer = solveEven(s.toLowerCase());
        } else {
            answer = solveOdd(s.toLowerCase());
        }

        System.out.println(answer);
    }

    static String solveEven(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        int oddCount = 0;
        for (int i : alphabet) {
            if (i % 2 == 1) {
                oddCount++;
            }

            if (oddCount == 2) {
                return "I'm Sorry Hansoo";
            }
        }

        for (int i = alphabet.length - 1; i >= 0; i--) {
            int count = alphabet[i];

            if (count == 0) {
                continue;
            }

            char c = (char) (i + 'a');

            for (int j = 0; j < count; j++) {
                if (j % 2 == 0) {
                    dq.push(c);
                } else {
                    dq.addLast(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!dq.isEmpty()) {
            result.append(dq.removeFirst());
        }

        return result.toString().toUpperCase();
    }

    static String solveOdd(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        int[] alphabet = new int[26];
        char oddAlphabet = 'a';

        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }

        int oddCount = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0) {
                continue;
            }

            if (alphabet[i] % 2 == 1) {
                oddAlphabet = (char) (i + 'a');
                oddCount++;
            }

            if (oddCount == 2) {
                return "I'm Sorry Hansoo";
            }
        }

        for (int i = alphabet.length - 1; i >= 0; i--) {
            int count = alphabet[i];

            if (count == 0) {
                continue;
            }

            char c = (char) (i + 'a');
            if (c == oddAlphabet) {
                while (alphabet[i] != 1) {
                    dq.addFirst(c);
                    dq.addLast(c);
                    alphabet[i] -= 2;
                }
                continue;
            }

            for (int j = 0; j < count; j++) {
                if (j % 2 == 0) {
                    dq.push(c);
                } else {
                    dq.addLast(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!dq.isEmpty()) {
            result.append(dq.removeFirst());
        }
        result.insert(result.length() / 2, oddAlphabet);
        return result.toString().toUpperCase();
    }
}
