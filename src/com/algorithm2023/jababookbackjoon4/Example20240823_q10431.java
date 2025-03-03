package com.algorithm2023.jababookbackjoon4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20240823_q10431 {

    static final Scanner sc = new Scanner(System.in);
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            solve();
        }

        System.out.println(sb.toString());
    }

    static void solve() {
        int order = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < 20; i++) {
            int nowHeight = sc.nextInt();
            int index = 0;

            // 앞에서부터 현재 학생의 키보다 큰 학생의 위치를 찾기
            while (index < list.size() && list.get(index) < nowHeight) {
                index++;
            }

            list.add(index, nowHeight);

            answer += list.size() - index - 1;
        }

        sb.append(order)
                .append(" ")
                .append(answer)
                .append("\n");
    }

}
