package com.algorithm2024.programers06;

import java.util.LinkedList;
import java.util.Queue;

public class Example20240829_TreasureHunt {// 프로그래머스 pccp 모의고사 보물찾기

    static int n;
    static int m;
    static int answer;
    static boolean[][] map;
    static boolean[][][] visit;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Node {
        int row;
        int col;
        int use;
        int time;

        public Node(int row, int col, int use, int time) {
            this.row = row;
            this.col = col;
            this.use = use;
            this.time = time;
        }
    }

    public int solution(int n, int m, int[][] hole) {
        this.n = m;
        this.m = n;
        map = new boolean[this.n][this.m];
        for (int i = 0; i < hole.length; i++) {
            map[this.n - hole[i][1]][hole[i][0] - 1] = true;
        }

        answer = -1;
        visit = new boolean[this.n][this.m][2];
        bfs();
        return answer;
    }

    private void bfs() {
        visit[this.n - 1][0][0] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(this.n - 1, 0, 0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.row == 0 && now.col == m - 1) {
                answer = now.time;
                return;
            }

            for (int[] p : pos) {
                int nr = now.row + p[0];
                int nc = now.col + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc][now.use] && !map[nr][nc]) {
                    visit[nr][nc][now.use] = true;
                    q.offer(new Node(nr, nc, now.use, now.time + 1));
                }
            }

            // 신발 처리
            if (now.use == 0) {
                for (int[] p : pos) {
                    int nr = now.row + p[0] * 2;
                    int nc = now.col + p[1] * 2;

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visit[nr][nc][now.use + 1] && !map[nr][nc]) {
                        visit[nr][nc][now.use + 1] = true;
                        q.offer(new Node(nr, nc, now.use + 1, now.time + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Example20240829_TreasureHunt sol = new Example20240829_TreasureHunt();

        // 5
        System.out.println(sol.solution(4, 4, new int[][]{{2, 3}, {3, 3}}));
    }

}
