package com.algorithm2025.backjoon2.day001;

import java.io.*;

public class Example20250303_Q10808 { // 알파벳 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] result = new int[26];
        char[] temp = br.readLine().toCharArray();

        for (char c : temp) {
            result[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
