package com.algorithm2023.jababookbackjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Example20240424_q12931_2 { //두배더하기 스트림겸 람다식이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(n).sum();
        int answer = 0;
        while (sum != 0) {
            int num = Arrays.stream(n).map(x -> x % 2).sum();
            sum -= num;
            answer += num;
            n = Arrays.stream(n).map(x -> x / 2).toArray();
            if (sum > 0) {
                answer++;
                sum /= 2;
            }
        }
        System.out.print(answer);
    }
}
