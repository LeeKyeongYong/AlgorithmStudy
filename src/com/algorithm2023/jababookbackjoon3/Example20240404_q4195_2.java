package com.algorithm2023.jababookbackjoon3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Example20240404_q4195_2 {
    static final StringBuilder sb = new StringBuilder();
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static int[] parent;
    static int[] values;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        values = new int[n * 2];
        parent = new int[n * 2];
        for (int i = 0; i < parent.length; i++) {
            values[i] = 1;
            parent[i] = i;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (!map.containsKey(a)) {
                map.put(a, index++);
            }
            if (!map.containsKey(b)) {
                map.put(b, index++);
            }

            sb.append(union(map.get(a), map.get(b)))
                    .append("\n");
        }
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        // x < y
        if (x != y) {
            parent[y] = x;
            values[x] += values[y];

            values[y] = 1;
        }

        return values[x];
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }
}
