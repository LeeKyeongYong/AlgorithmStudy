package com.jababookbacojoon5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Example20241010_q20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < n; r++) {
            int now = arr[r];
            map.put(now, map.getOrDefault(now, 0) + 1);

            while (map.get(now) > k) {
                int left = arr[l];
                map.put(left, map.get(left) - 1);
                l++;
            }

            answer = Math.max(answer, r - l + 1);
        }

        System.out.println(answer);
    }
}
