package com.algorithm2024.programers04;

import java.util.*;

public class Example20240704_05 { //2021 KAKAO BLIND RECRUITMENT 카드 짝 맞추기

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public int solution(int[][] board, int r, int c) {
        Set<String> visit = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        String serializedBoard = serialize(board);

        visit.add(getStateKey(serializedBoard, r, c, false, -1, -1));
        queue.add(new State(serializedBoard, r, c, false, -1, -1, 0));

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            // Check if all cards are flipped
            if (isEnd(curr.board)) {
                return curr.count;
            }

            // Move in four directions
            for (int k = 0; k < 4; k++) {
                int ny = curr.y + dy[k];
                int nx = curr.x + dx[k];

                if (OOB(ny, nx)) continue;

                while (curr.board.charAt(idxConverter(ny, nx)) == '0' && !isOnEdgeByDirection(ny, nx, k)) {
                    ny += dy[k];
                    nx += dx[k];
                }

                String nextStateKey = getStateKey(curr.board, ny, nx, curr.isFlipped, curr.fy, curr.fx);
                if (!visit.contains(nextStateKey)) {
                    visit.add(nextStateKey);
                    queue.add(new State(curr.board, ny, nx, curr.isFlipped, curr.fy, curr.fx, curr.count + 1));
                }
            }

            // Move one step in four directions
            for (int k = 0; k < 4; k++) {
                int ny = curr.y + dy[k];
                int nx = curr.x + dx[k];

                if (OOB(ny, nx)) continue;

                String nextStateKey = getStateKey(curr.board, ny, nx, curr.isFlipped, curr.fy, curr.fx);
                if (!visit.contains(nextStateKey)) {
                    visit.add(nextStateKey);
                    queue.add(new State(curr.board, ny, nx, curr.isFlipped, curr.fy, curr.fx, curr.count + 1));
                }
            }

            // Flip cards
            if (curr.isFlipped) {
                if (curr.board.charAt(idxConverter(curr.fy, curr.fx)) == curr.board.charAt(idxConverter(curr.y, curr.x)) && (curr.fy != curr.y || curr.fx != curr.x)) {
                    String newBoard = switchTo0(curr.board, curr.board.charAt(idxConverter(curr.fy, curr.fx)));

                    if (isEnd(newBoard)) {
                        return curr.count + 1;
                    }

                    String nextStateKey = getStateKey(newBoard, curr.y, curr.x, false, -1, -1);
                    if (!visit.contains(nextStateKey)) {
                        visit.add(nextStateKey);
                        queue.add(new State(newBoard, curr.y, curr.x, false, -1, -1, curr.count + 1));
                    }
                } else {
                    String nextStateKey = getStateKey(curr.board, curr.y, curr.x, false, -1, -1);
                    if (!visit.contains(nextStateKey)) {
                        visit.add(nextStateKey);
                        queue.add(new State(curr.board, curr.y, curr.x, false, -1, -1, curr.count + 1));
                    }
                }
            } else {
                String nextStateKey = getStateKey(curr.board, curr.y, curr.x, true, curr.y, curr.x);
                if (!visit.contains(nextStateKey)) {
                    visit.add(nextStateKey);
                    queue.add(new State(curr.board, curr.y, curr.x, true, curr.y, curr.x, curr.count + 1));
                }
            }
        }

        return -1; // Should not reach here
    }

    private boolean isEnd(String board) {
        return !board.contains("1") && !board.contains("2") && !board.contains("3") && !board.contains("4") && !board.contains("5") && !board.contains("6");
    }

    private boolean OOB(int y, int x) {
        return y < 0 || y >= 4 || x < 0 || x >= 4;
    }

    private boolean isOnEdgeByDirection(int y, int x, int d) {
        if (d == 0 && y == 0) return true;
        if (d == 1 && y == 3) return true;
        if (d == 2 && x == 0) return true;
        if (d == 3 && x == 3) return true;
        return false;
    }

    private String serialize(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    private String switchTo0(String board, char num) {
        return board.replace(num, '0');
    }

    private int idxConverter(int y, int x) {
        return 4 * y + x;
    }

    private String getStateKey(String board, int y, int x, boolean isFlipped, int fy, int fx) {
        return board + "," + y + "," + x + "," + isFlipped + "," + fy + "," + fx;
    }

    private static class State {
        String board;
        int y, x, count;
        boolean isFlipped;
        int fy, fx;

        State(String board, int y, int x, boolean isFlipped, int fy, int fx, int count) {
            this.board = board;
            this.y = y;
            this.x = x;
            this.isFlipped = isFlipped;
            this.fy = fy;
            this.fx = fx;
            this.count = count;
        }
    }

}
