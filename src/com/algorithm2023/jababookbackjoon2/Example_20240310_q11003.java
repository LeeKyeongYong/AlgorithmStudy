package com.algorithm2023.jababookbackjoon2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Example_20240310_q11003 {
    private static final int VALUE = 0;
    private static final int INDEX = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast()[0] > num) {
                dq.pollLast();
            }

            dq.offer(new int[]{num, i});
            if (dq.peek()[INDEX] < i - (l - 1)) {
                dq.poll();
            }

            bw.write(dq.peek()[VALUE] + " ");
        }

        bw.flush();
        bw.close();
    }
}
