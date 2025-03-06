package com.algorithm2025.backjoon2.day005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example20250306_Q11365 {// !밀비급일

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            String text = br.readLine();
            if ("END".equals(text)) break;

            StringBuilder reversed = new StringBuilder(text).reverse();
            result.append(reversed).append('\n');
        }

        System.out.print(result);
        br.close();
    }
}