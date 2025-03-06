package com.algorithm2025.backjoon2.day005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Example20250306_Q1264 {// 모음의 개수
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        while (true) {
            String line = br.readLine();
            if ("#".equals(line)) {
                break;
            }

            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (vowels.contains(c)) {
                    count++;
                }
            }

            sb.append(count).append('\n');
        }

        // 한 번에 모든 결과 출력
        System.out.print(sb);
        br.close();
    }
}