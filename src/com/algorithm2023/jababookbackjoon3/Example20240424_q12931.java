package com.algorithm2023.jababookbackjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example20240424_q12931 { //두배더하기
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int solve() {
        int cnt = 0;
        while (true) {
            // 배열의 홀수 원소 개수를 카운트
            int oddCount = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 1) {
                    oddCount++;
                }
            }

            // 모든 원소가 0인 경우 종료
            if (oddCount == 0) {
                break;
            }

            // 홀수 원소 개수만큼 연산을 수행하고, 배열을 업데이트
            cnt += oddCount;
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 1) {
                    arr[i]--;
                }
                arr[i] /= 2;
            }

            // 한 번의 연산이 끝날 때마다 연산 횟수 증가
            cnt++;
        }
        return cnt;
    }
}
