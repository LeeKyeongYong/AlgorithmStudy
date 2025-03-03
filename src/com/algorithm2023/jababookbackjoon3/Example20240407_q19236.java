package com.algorithm2023.jababookbackjoon3;

import java.util.Scanner;

public class Example20240407_q19236 {
    static int[][] pos = {{-1, 0}, {-1, -1,}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static int[][] map;
    static Fish[] fish;
    static int answer;

    static class Fish {
        int id;
        int row;
        int col;
        int dir;
        boolean isLive;

        public Fish(final int id, final int row, final int col, final int dir, final boolean isLive) {
            this.id = id;
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.isLive = isLive;
        }

        void dead() {
            this.isLive = false;
        }

        void alive() {
            this.isLive = true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[4][4];
        fish = new Fish[17];
        answer = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int id = sc.nextInt();
                int dir = sc.nextInt() - 1;
                fish[id] = new Fish(id, i, j, dir, true);
                map[i][j] = id;
            }
        }

        int sRow = 0;
        int sCol = 0;
        int sDir = fish[map[0][0]].dir;
        int eat = fish[map[0][0]].id;
        fish[map[0][0]].dead();
        map[0][0] = -1;

        dfs(sRow, sCol, sDir, eat);
        System.out.println(answer);
    }

    static void dfs(int sRow, int sCol, int sDir, int eat) {
        // 정답 갱신
        answer = Math.max(answer, eat);

        // 맵, 물고기 복제
        int[][] copyMap = copy(map);
        Fish[] copyFish = copyFish();

        // 물고기 이동
        moveFish();

        // 상어 이동
        for (int i = 1; i < 4; i++) {
            int nr = sRow + pos[sDir][0] * i;
            int nc = sCol + pos[sDir][1] * i;

            if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != 0) {
                int eatFishId = map[nr][nc];
                int nd = fish[eatFishId].dir;

                map[sRow][sCol] = 0;
                map[nr][nc] = -1;
                fish[eatFishId].dead();

                dfs(nr, nc, nd, eat + eatFishId);

                fish[eatFishId].alive();
                map[sRow][sCol] = -1;
                map[nr][nc] = eatFishId;
            }
        }

        // 맵, 물고기 복구
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(copyMap[i], 0, map[i], 0, map.length);
        }

        for (int i = 1; i <= 16; i++) {
            fish[i] = new Fish(copyFish[i].id, copyFish[i].row, copyFish[i].col, copyFish[i].dir, copyFish[i].isLive);
        }
    }

    static void moveFish() {
        for (int i = 1; i <= 16; i++) {
            Fish now = fish[i];

            // 죽으면 움직일 필요가 없음
            if (!now.isLive) {
                continue;
            }

            int count = 0;
            int dir = now.dir;
            int nr = 0;
            int nc = 0;

            // 갈 수 있는 거리 찾기
            while (count < 8) {
                dir %= 8;
                now.dir = dir;

                nr = now.row + pos[dir][0];
                nc = now.col + pos[dir][1];
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && map[nr][nc] != -1) {
                    // 상어가 없다면 이동

                    if (map[nr][nc] == 0) {
                        // 이동 위치 == 빈칸
                        map[now.row][now.col] = 0;
                        now.row = nr;
                        now.col = nc;
                        map[nr][nc] = i;
                    } else {
                        // 이동 위치 == 물고기 있음
                        int changeFishId = fish[map[nr][nc]].id;

                        fish[changeFishId].row = now.row;
                        fish[changeFishId].col = now.col;
                        map[fish[changeFishId].row][fish[changeFishId].col] = changeFishId;

                        now.row = nr;
                        now.col = nc;
                        map[nr][nc] = i;
                    }
                    break;
                } else {
                    // 상어가 있다면
                    dir++;
                    count++;
                }
            }
        }
    }

    private static Fish[] copyFish() {
        Fish[] copyFish = new Fish[fish.length];

        for (int i = 1; i <= 16; i++) {
            copyFish[i] = new Fish(fish[i].id, fish[i].row, fish[i].col, fish[i].dir, fish[i].isLive);
        }

        return copyFish;
    }

    static int[][] copy(int[][] map) {
        int[][] copyMap = new int[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }
}
