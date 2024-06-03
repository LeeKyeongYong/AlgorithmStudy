package com.algorithm2024.letcode3;

public class Example20240603_q2486 {
    // t에서 앞에서부터 쭉 연결된 것이 아니면 모두 추가하기
    // ex. co(d)i 에서 d가 없다면 2개만 연결된 것
    public static int appendCharacters(String s, String t) {
        int left = 0;
        int right = 0;

        while (left < s.length() && right < t.length()) {
            // s의 left와 t의 right가 같은 경우
            if (s.charAt(left) == t.charAt(right)) {
                right++;
            }

            left++;
        }

        return t.length() - right;
    }

    public static void main(String[] args) {
        // 4
        System.out.println(appendCharacters("coaching", "coding"));

        // 3
        System.out.println(appendCharacters("coaching", "coding"));
    }
}
