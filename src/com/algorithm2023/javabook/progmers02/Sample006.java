package com.algorithm2023.javabook.progmers02;

public class Sample006 {
    public static void main(String[] args) {
        Solution006 s = new Solution006();
        int n = 3628800;
        int solution = s.solution(n);
        System.out.println("팩토리얼 계산 결과: " + solution);
    }
}

class Solution006 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= 10; i++) {
            if (fac(i) <= n) {
                answer = i;
            }
        }
        return answer;
    }

    int fac(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fac(n - 1);
        }
    }
}
