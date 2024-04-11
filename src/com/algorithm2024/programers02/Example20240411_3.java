package com.algorithm2024.programers02;

import java.util.Arrays;
import java.util.Stack;

public class Example20240411_3 { //뒤큰수
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<int[]> stack = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            int num = numbers[i];

            // 스택이 있다면 자기 보다 큰 수가 나올때 까지 pop한다
            while (true) {
                if (stack.isEmpty()) {
                    break;
                }

                if (stack.peek()[1] <= num) {
                    stack.pop();
                } else {
                    break;
                }
            }

            // 스택이 비어있다면 자신을 push하고 -1
            if (stack.isEmpty()) {
                stack.push(new int[]{i, num});
                answer[i] = -1;
                continue;
            }

            // 스택이 있다면 peek()하고 해당 인덱스를 값으로 두고 자신을 push 한다
            answer[i] = stack.peek()[1];
            stack.push(new int[]{i, num});
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};

        // -1 5 6 6 -1 -1
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
