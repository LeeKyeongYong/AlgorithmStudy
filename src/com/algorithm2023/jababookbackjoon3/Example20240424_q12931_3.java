package com.algorithm2023.jababookbackjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example20240424_q12931_3 { //두배더하기 간결하고 가독성 람다식 두번째 버전
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] n = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = Arrays.stream(n).sum();
        int answer = 0;

        while (sum != 0) {
            int num = (int) Arrays.stream(n)
                    .filter(x -> x % 2 == 1)
                    .map(x -> {
                        x--;
                        return 1;
                    })
                    .count();

            if (num > 0) {
                sum -= num;
                answer += num;
            } else {
                sum /= 2;
                answer++;
                Arrays.setAll(n, x -> x / 2);
            }
        }

        System.out.print(answer);
    }
}
