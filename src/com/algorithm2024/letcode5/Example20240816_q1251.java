package com.algorithm2024.letcode5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example20240816_q1251 {
    static String str;
    static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        list = new ArrayList<>();

        permutation(0, 0, new ArrayList<>());
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    static void permutation(int index, int start, List<String> now) {
        if (index >= 4) {
            return;
        }

        if (index == 3 && start == str.length()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder temp = new StringBuilder();

            for (String s : now) {
                temp = new StringBuilder(s);
                sb.append(temp.reverse().toString());
            }

            list.add(sb.toString());
            return;
        }

        for (int i = start; i < str.length(); i++) {
            now.add(str.substring(start, i + 1));
            permutation(index + 1, i + 1, now);
            now.remove(now.size() - 1);
        }
    }
}
