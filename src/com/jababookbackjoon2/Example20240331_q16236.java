package com.jababookbackjoon2;

import java.util.*;

public class Example20240331_q16236 {
    static int n;
    static int[][] map;
    static Shark shark;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static class Shark {
        int row;
        int col;
        int size;
        int eatCount;

        public Shark(final int row, final int col, final int size) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.eatCount = 0;
        }

        void addEatCount() {
            this.eatCount++;

            if (this.eatCount == size) {
                this.size++;
                this.eatCount = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2);
                }
            }
        }

        while (true) {
            // 1. 먹을 수 있는 물고기가 있는지 확인하고 몇 마리인지 반환한다.
            List<Shark> fishes = countCanEatFishes();

            // 2-1. 먹을 수 있는 물고기가 없다면 멈춘다.
            if (fishes.isEmpty()) {
                break;
            }

            // 2-2. 먹을 수 있는 물고기가 한 마리면 그 물고기를 잡는다.
            if (fishes.size() == 1) {
                eatTarget(fishes.get(0));
                continue;
            }

            // 2.3 먹을 수 있는 물고기가 여러 마리라면 가까운 물고기를 잡는다
            Shark target = getTarget();
            eatTarget(target);
        }

        System.out.println(answer);
    }

    // 3번 과정
    static Shark getTarget() {
        // 1. 거리가 가까운 물고기를 찾는다
        List<Shark> targets = getTargetsPosition();

        if (targets.size() == 1) {
            return targets.get(0);
        }

        // 2. 가장 가까운 물고기가 많다면 가장 위에 있는 물고기를 찾는다.
        targets = findMostRowMaxFishes(targets);

        if (targets.size() == 1) {
            return targets.get(0);
        }

        // 3. 가장 위에 있는 물고기가 많다면 가장 왼쪽에 있는 물고기를 찾는다.
        int col = Integer.MAX_VALUE;
        Shark fish = null;
        for (Shark target : targets) {
            if (target.col < col) {
                col = target.col;
                fish = target;
            }
        }

        return fish;
    }

    static List<Shark> findMostRowMaxFishes(List<Shark> targets) {
        int minRow = Integer.MAX_VALUE;

        for (Shark target : targets) {
            if (target.row < minRow) {
                minRow = target.row;
            }
        }

        List<Shark> fishes = new ArrayList<>();
        for (Shark target : targets) {
            if (target.row == minRow) {
                fishes.add(target);
            }
        }

        return fishes;
    }

    static List<Shark> getTargetsPosition() {
        // TODO
        List<Shark> temp = new ArrayList<>();
        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dp[shark.row][shark.col] = 0;
        visited[shark.row][shark.col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{shark.row, shark.col});
        int minSize = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc])) {
                    continue;
                }

                if (map[nr][nc] > shark.size) {
                    continue;
                }

                if (map[nr][nc] <= shark.size) {
                    if (map[nr][nc] >= 1 && map[nr][nc] < shark.size) {
                        // 자기보다 작은 놈들을 만나면
                        temp.add(new Shark(nr, nc, map[nr][nc]));
                        minSize = Math.min(minSize, map[nr][nc]);
                    }

                    q.add(new int[]{nr, nc});
                    dp[nr][nc] = dp[now[0]][now[1]] + 1;
                    visited[nr][nc] = true;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (Shark shark1 : temp) {
            if (dp[shark1.row][shark1.col] < minDistance) {
                minDistance = dp[shark1.row][shark1.col];
            }
        }

        List<Shark> fishes = new ArrayList<>();
        for (Shark shark1 : temp) {
            if (dp[shark1.row][shark1.col] == minDistance) {
                fishes.add(shark1);
            }
        }

        return fishes;
    }

    static void eatTarget(Shark target) {
        int targetRow = target.row;
        int targetCol = target.col;
        boolean eat = false;

        int[][] dp = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dp[shark.row][shark.col] = 0;
        visited[shark.row][shark.col] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{shark.row, shark.col});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == targetRow && now[1] == targetCol) {
                shark.addEatCount();
                eat = true;

                map[shark.row][shark.col] = 0;
                shark.row = targetRow;
                shark.col = targetCol;
                map[targetRow][targetCol] = 9;

                answer += dp[targetRow][targetCol];
                break;
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc])) {
                    continue;
                }

                if (map[nr][nc] > shark.size) {
                    continue;
                }

                if (map[nr][nc] <= shark.size) {
                    q.add(new int[]{nr, nc});
                    dp[nr][nc] = dp[now[0]][now[1]] + 1;
                    visited[nr][nc] = true;
                }
            }
        }

        if (!eat) {
            System.out.println(answer);
            System.exit(1);
        }
    }

    static List<Shark> countCanEatFishes() {
        List<Shark> sharks = new ArrayList<>();
        int mySize = shark.size;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 1 && map[i][j] < mySize) {
                    sharks.add(new Shark(i, j, map[i][j]));
                }
            }
        }

        return sharks;
    }
}
