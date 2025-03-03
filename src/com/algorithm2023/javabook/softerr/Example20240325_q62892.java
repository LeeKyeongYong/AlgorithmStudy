package com.algorithm2023.javabook.softerr;

import java.util.ArrayList;
import java.util.Scanner;

public class Example20240325_q62892 {
    static int n;
    static int m;
    static int[] arr;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            list[a].add(b);
            list[b].add(a);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean isKing = true;

            for (Integer friend : list[i]) {
                if (arr[i] <= arr[friend]) {
                    isKing = false;
                    break;
                }
            }

            if (isKing) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
