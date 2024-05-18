package com.algorithm2024.letcode2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Example20240518_q26122 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();

        Stack<Integer> stackN = new Stack<>();
        Stack<Integer> stackS = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) == 'N') {
                stackN.push(1);
                if (!flag) {
                    temp.add(stackS.size());
                    while (!stackS.isEmpty()) {
                        stackS.pop();
                    }
                }
                flag = true;
            } else if (s.charAt(i) == 'S') {
                stackS.push(1);
                if (flag) {
                    temp.add(stackN.size());
                    while (!stackN.isEmpty()) {
                        stackN.pop();
                    }
                }
                flag = false;
            }
        }

        if (flag) {
            temp.add(stackN.size());
        } else {
            temp.add(stackS.size());
        }

        temp.add(0);

        int res = 0;

        for (int i = 1; i < temp.size(); i++) {
            res = Math.max(res, 2 * Math.min(temp.get(i - 1), temp.get(i)));
        }

        System.out.println(res);
    }
}