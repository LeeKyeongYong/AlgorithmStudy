package com.algorithm2024.programers04;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example20240706_01 { //2020 카카오 인턴십 경주로 건설

    private static final int INF = Integer.MAX_VALUE;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static final int[] direction = {0, 1, 2, 3}; // 오른쪽, 왼쪽, 아래, 위

    public static int solution(int[][] board) {
        int N = board.length;
        int[][][] costBoard = new int[4][N][N];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    costBoard[i][j][k] = INF;
                }
            }
        }

        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        heap.offer(new Node(0, 0, 0, 0)); // (cost, x, y, direction)
        heap.offer(new Node(0, 0, 0, 2)); // (cost, x, y, direction)

        while (!heap.isEmpty()) {
            Node current = heap.poll();
            int cost = current.cost;
            int x = current.x;
            int y = current.y;
            int d = current.direction;

            // 4방향 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 경계 침범 or 벽
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[ny][nx] == 1) {
                    continue;
                }

                // 이동비용 갱신
                int newCost = cost + (d == i ? 100 : 600);

                // 최소비용 갱신
                if (costBoard[i][ny][nx] > newCost) {
                    costBoard[i][ny][nx] = newCost;
                    heap.offer(new Node(newCost, nx, ny, i));
                }
            }
        }

        return Math.min(
                Math.min(costBoard[0][N-1][N-1], costBoard[1][N-1][N-1]),
                Math.min(costBoard[2][N-1][N-1], costBoard[3][N-1][N-1])
        );
    }

    private static class Node {
        int cost;
        int x;
        int y;
        int direction;

        Node(int cost, int x, int y, int direction) {
            this.cost = cost;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }



}
