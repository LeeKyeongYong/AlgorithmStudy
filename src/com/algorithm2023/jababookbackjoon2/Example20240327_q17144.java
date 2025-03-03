package com.algorithm2023.jababookbackjoon2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Example20240327_q17144 {
    static int n;
    static int m;
    static int t;
    static int[][] map;
    static int[] cleanerRows;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        map = new int[n][m];
        cleanerRows = new int[2];

        int clearnerIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == -1) {
                    cleanerRows[clearnerIndex] = i;
                    clearnerIndex++;
                }
            }
        }

        while (t-- > 0) {
            // 1. 미세먼지 확산 시키기
            spreadAll();

            // 2. 공기 청정기 작동시키기
            run();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer += map[i][j];
            }
        }

        System.out.println(answer + 2);
    }

    static void run() {
        int cleanerToReverseClockRow = cleanerRows[0];
        int cleanerToClockRow = cleanerRows[1];

        for (int row = cleanerToReverseClockRow - 1; row > 0; row--) {
            map[row][0] = map[row - 1][0];
        }

        for (int col = 0; col < m - 1; col++) {
            map[0][col] = map[0][col + 1];
        }

        for (int row = 0; row < cleanerToReverseClockRow; row++) {
            map[row][m - 1] = map[row + 1][m - 1];
        }

        for (int col = m - 1; col > 1; col--) {
            map[cleanerToReverseClockRow][col] = map[cleanerToReverseClockRow][col - 1];
        }
        map[cleanerToReverseClockRow][1] = 0;

        for (int row = cleanerToClockRow + 1; row < n - 1; row++) {
            map[row][0] = map[row + 1][0];
        }

        for (int col = 0; col < m - 1; col++) {
            map[n - 1][col] = map[n - 1][col + 1];
        }

        for (int row = n - 1; row > cleanerToClockRow; row--) {
            map[row][m - 1] = map[row - 1][m - 1];
        }

        for (int col = m - 1; col > 1; col--) {
            map[cleanerToClockRow][col] = map[cleanerToClockRow][col - 1];
        }
        map[cleanerToClockRow][1] = 0;
    }

    // clear 미세먼지 퍼뜨리기
    static void spreadAll() {
        List<int[]> spreadPosition = new ArrayList<>();

        // 1. 퍼뜨려야하는 것들을 모두 기록한다
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 1) {
                    spreadPosition.add(new int[]{i, j});
                }
            }
        }

        // 2. 각자 퍼뜨린다.
        int[][] prefix = new int[n][m]; // 모두 한 번에 반영 시키기 위해 나중에 반영하는 임시 저장 공간

        for (int[] position : spreadPosition) {
            List<int[]> nearPosition = new ArrayList<>();

            for (int[] p : pos) {
                int nr = position[0] + p[0];
                int nc = position[1] + p[1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != -1)) {
                    continue;
                }

                nearPosition.add(new int[]{nr, nc});
            }

            int originValue = map[position[0]][position[1]];
            int spreadCount = nearPosition.size();
            int spreadValue = (int) Math.floor(originValue / 5);


            // 3. 퍼뜨리고 값을 계산 시킨다
            map[position[0]][position[1]] = originValue - (spreadValue * spreadCount);

            for (int[] near : nearPosition) {
                prefix[near[0]][near[1]] += spreadValue;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] += prefix[i][j];
            }
        }
    }
}
