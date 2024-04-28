package com.javabook.datastructure;

public class Example20240428_02 {
    public static int solution(String s) {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i <= s.length() - 3; i++) {
            String sub = s.substring(i, i + 3);

            char index = sub.charAt(0);
            boolean isSame = true;
            for (int j = 0; j < sub.length(); j++) {
                if (index != sub.charAt(j)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                int num = Integer.parseInt(sub);
                answer = Math.max(answer, num);
            }

        }

        if (answer == Integer.MIN_VALUE) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("111"));
    }
}
