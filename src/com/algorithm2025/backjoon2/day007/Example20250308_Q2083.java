package com.algorithm2025.backjoon2.day007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Example20250308_Q2083 { // 럭비클럽
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                String name = st.nextToken();
                int age = Integer.parseInt(st.nextToken());
                int kg = Integer.parseInt(st.nextToken());
                if (name.equals("#") && age == 0 && kg == 0) break;
                sb.append(name)
                        .append(" ")
                        .append((age > 17 || kg >= 80) ? "Senior" : "Junior")
                        .append("\n");
            }
            System.out.print(sb);
        }
    }
}
