package com.algorithm2025.backjoon2.day005;

import java.util.HashMap;
import java.util.Map;

public class Example20250306_Q1830 { // 코딩테스트 연습 2017 카카오코드 예선 브라이언의 고민

    private char[] arr;
    private final boolean[] used = new boolean[26];
    private final Map<Integer, String> map = new HashMap<>();

    private static final String INVALID = "invalid";

    public String solution(String sentence) {
        arr = sentence.toCharArray();
        for (char c : arr)
            if (c == ' ')
                return INVALID;

        return solve(0, arr.length - 1, false).trim();
    }

    String solve(int s, int e, boolean isInner) {
        if (s > e)
            return "";

        if (map.containsKey(s))
            return map.get(s);

        if (s + 1 <= e && isLower(arr[s]) && isLower(arr[s + 1]))
            return process(s, INVALID, false, ' ');

        StringBuilder sb = new StringBuilder();
        if (!isInner && isLower(arr[s])) { // 규칙 2인 경우
            int l2 = s;

            char c = arr[l2];
            if (used[c - 'a'])
                return process(s, INVALID, false, ' ');

            used[c - 'a'] = true;

            int r2 = find(l2, c);
            if (r2 == -1)
                return process(s, INVALID, true, c);

            String inner = solve(l2 + 1, r2 - 1, true).replace(" ", "").trim();
            String outer = solve(r2 + 1, e, false).trim();

            if (inner.contains(INVALID) || outer.contains(INVALID))
                return process(s, INVALID, true, c);

            String result = inner + " " + outer;
            return process(s, result, false, ' ');

        } else { // 규칙2가 아닌 경우
            if (isLower(arr[s]) || (isInner && !formatted(s, e)))
                return process(s, INVALID, false, ' ');

            int l = s;
            if (l + 1 <= e && isLower(arr[l + 1])) { //대문자 + 소문자 유형인 경우

                String solved = solve(l + 1, e, isInner).trim();
                if (!solved.contains(INVALID))
                    return process(s, arr[l] + " " + solved, false, ' ');

                char c = arr[l + 1];
                if (used[c - 'a'])
                    return process(s, INVALID, false, ' ');

                used[c - 'a'] = true;

                for (int k = 0; l <= e; l++, k++) {
                    if (isUpper(arr[l])) {
                        if (k % 2 == 1)
                            break;

                        sb.append(arr[l]);
                    } else {
                        if (l == e || k % 2 == 0)
                            return process(s, INVALID, true, c);

                        if (arr[l] != c)
                            break;
                    }
                }

                solved = solve(l, e, isInner).trim();
                if (!solved.contains(INVALID))
                    return process(s, sb + " " + solved, false, ' ');

                return process(s, INVALID, true, c);

            } else {
                while (l <= e && !isLower(arr[l]))
                    sb.append(arr[l++]);

                String solved = solve(l, e, isInner).trim();
                if (!solved.contains(INVALID))
                    return process(s, sb + " " + solved, false, ' ');

                sb.deleteCharAt(sb.length() - 1);
                solved = solve(l - 1, e, false).trim();
                if (!solved.contains(INVALID))
                    return process(s, sb + " " + solved, false, ' ');

                return process(s, INVALID, false, ' ');
            }
        }
    }

    private boolean formatted(int s, int e) {
        if (s == e)
            return !isLower(arr[s]);

        if (isLower(arr[s]))
            return false;

        if (isLower(arr[s + 1])) {
            int lower = 0, upper = 0;
            for (int i = s, k = 0; i <= e; i++, k++) {
                if (isUpper(arr[i])) {
                    if (k % 2 == 1)
                        return false;

                    upper++;
                } else {
                    if (k % 2 == 0)
                        return false;

                    lower++;
                }
            }

            return lower != upper;
        } else {
            for (int i = s; i <= e; i++)
                if (isLower(arr[i]))
                    return false;
        }

        return true;
    }

    private int find(int s, char c) {
        for (int i = s + 1; i < arr.length; i++)
            if (arr[i] == c)
                return i;

        return -1;
    }

    boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    String process(int s, String result, boolean hasReset, char c) { // 메모이제이션, 사용한 문자 false 처리
        if (hasReset)
            used[c - 'a'] = false;

        map.put(s, result);
        return result;
    }
}