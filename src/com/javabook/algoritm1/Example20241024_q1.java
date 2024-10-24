package com.javabook.algoritm1;

import java.util.Scanner;

public class Example20241024_q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int sum = prefix[end] - prefix[start - 1];
            double average = (double) sum / (end - start + 1);

            sb.append(String.format("%.2f",(average)))
                    .append("\n");
        }

        System.out.println(sb.toString());
    }

}
