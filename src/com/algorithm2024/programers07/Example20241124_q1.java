package com.algorithm2024.programers07;

import java.util.HashSet;
import java.util.Set;

public class Example20241124_q1 {
    public String[] solution(int[][] line) {
        int N = line.length;
        final long INF = Long.MAX_VALUE;
        Set<String> crossPoints = new HashSet<>();  // 중복을 제거하기 위해 Set 사용
        long minX = INF, minY = INF, maxX = -INF, maxY = -INF;

        // 모든 정수 교차점과 좌표의 최대/최솟값을 구합니다.
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];

                long mod = a * d - b * c;
                if (mod == 0) continue; // 분모가 0인 경우 -> 서로 평행하거나 일치

                long xNumerator = b * f - e * d;
                long yNumerator = e * c - a * f;
                if (xNumerator % mod != 0 || yNumerator % mod != 0) continue; // 정수가 아닌 교차점

                long x = xNumerator / mod;
                long y = yNumerator / mod;

                String point = x + "," + y; // 좌표를 문자열로 변환하여 Set에 추가
                if (crossPoints.add(point)) {  // 중복 체크 후 추가
                    minX = Math.min(minX, x); // 좌표 최대/최솟값 갱신
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        // 너비와 높이를 계산 후, 별을 찍습니다.
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] paper = new char[height][width];

        // 초기화
        for (int i = 0; i < height; i++) {
            java.util.Arrays.fill(paper[i], '.'); // Arrays.fill로 초기화
        }

        // 교차점에 별 찍기
        for (String point : crossPoints) {
            String[] parts = point.split(",");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            paper[(int) (maxY - y)][(int) (x - minX)] = '*';
        }

        // 결과를 문자열 배열로 변환
        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(paper[i]);
        }

        return result;
    }
}