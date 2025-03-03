package com.algorithm2023.javabook.progmers02;

public class Sample016 { // 최댓값 구하기
    public static void main(String[] args) {
        int[] numbers = {0, -31, 24, 10, 1, 9};
        Solution16 s = new Solution16();
        int solution = s.solution(numbers);
        System.out.println("최댓값 구하기 result: " + solution);
    }
}

class Solution16 {
    public int solution(int[] numbers) {
        int answer = 0;

        for (int X = 0; X < numbers.length - 1; X++) {
            for (int Y = X + 1; Y < numbers.length; Y++) { // 모든 조합 비교
                if (numbers[X] < numbers[Y]) {
                    int C = numbers[X];
                    numbers[X] = numbers[Y];
                    numbers[Y] = C;
                }
            }
        }

        int num1 = numbers[0] * numbers[1];
        int num2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

        if (num1 < num2) {
            answer = num2;
        } else {
            answer = num1;
        }

        return answer;
    }
}
