package com.jababookbacojoon5;

import java.util.Scanner;
import java.util.Stack;

public class Example20240913_q17952 {
    static class Task {
        int score;
        int last;

        public Task(final int score, final int last) {
            this.score = score;
            this.last = last;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int time = sc.nextInt();
        Stack<Task> stack = new Stack<>();

        for (int i = 0; i < time; i++) {
            int type = sc.nextInt();

            if (type == 0) {
                if (stack.isEmpty()) {
                    continue;
                }

                Task now = stack.pop();
                now.last -= 1;

                if (now.last == 0) {
                    answer += now.score;
                } else {
                    stack.push(now);
                }
                continue;
            }

            int score = sc.nextInt();
            int last = sc.nextInt();
            Task task = new Task(score, last - 1);
            if (task.last == 0) {
                answer += score;
                continue;
            }
            stack.push(task);
        }

        System.out.println(answer);
    }
}
