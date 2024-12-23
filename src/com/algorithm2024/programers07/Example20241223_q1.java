package com.algorithm2024.programers07;

import java.util.*;

interface PathFindingStrategy {
    boolean findPath(int startX, int startY, int endX, int endY, List<String> boards);
}

class BFSPathFinding implements PathFindingStrategy {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    @Override
    public boolean findPath(int startX, int startY, int endX, int endY, List<String> boards) {
        Queue<QInfo> queue = new LinkedList<>();
        queue.add(new QInfo(startX, startY, -1, 0));

        while (!queue.isEmpty()) {
            QInfo current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int direction = current.dir;
            int count = current.cnt;

            for (int i = 0; i < 4; i++) {
                if (direction != -1 && Math.abs(direction - i) == 2)
                    continue;

                int nextX = currentX + DIRECTIONS[i][0];
                int nextY = currentY + DIRECTIONS[i][1];
                int nextCount = (direction == i || direction == -1) ? count : count + 1;

                if (isInRange(nextX, nextY, boards)) {
                    char nextChar = boards.get(nextX).charAt(nextY);
                    if (nextChar == '*') {
                        continue;
                    } else if (nextChar == '.') {
                        queue.add(new QInfo(nextX, nextY, i, nextCount));
                    } else {
                        if (nextX == endX && nextY == endY)
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isInRange(int x, int y, List<String> boards) {
        return (0 <= x && x < boards.size() && 0 <= y && y < boards.get(0).length());
    }
}

class QInfo {
    int x, y, dir, cnt;

    QInfo(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }
}

class AInfo {
    int x, y;

    AInfo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class BoardState {
    private List<String> boards;
    private int pairCount;

    BoardState(List<String> boards, int pairCount) {
        this.boards = boards;
        this.pairCount = pairCount;
    }

    public List<String> getBoards() {
        return boards;
    }

    public int getPairCount() {
        return pairCount;
    }

    public void decrementPairCount() {
        pairCount--;
    }

    public void updateBoard(int x, int y, char replacement) {
        StringBuilder row = new StringBuilder(boards.get(x));
        row.setCharAt(y, replacement);
        boards.set(x, row.toString());
    }
}

class PuzzleSolver {
    private PathFindingStrategy pathFindingStrategy;

    PuzzleSolver(PathFindingStrategy pathFindingStrategy) {
        this.pathFindingStrategy = pathFindingStrategy;
    }

    public String solve(List<List<AInfo>> arr, BoardState boardState) {
        StringBuilder ans = new StringBuilder();
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).size() > 1) {
                    AInfo start = arr.get(i).get(0);
                    AInfo end = arr.get(i).get(1);
                    if (pathFindingStrategy.findPath(start.x, start.y, end.x, end.y, boardState.getBoards())) {
                        boardState.updateBoard(start.x, start.y, '.');
                        boardState.updateBoard(end.x, end.y, '.');
                        arr.get(i).clear();
                        boardState.decrementPairCount();
                        ans.append((char) (i + 'A'));
                        flag = true;
                        break;
                    }
                }
            }
        }

        return boardState.getPairCount() == 0 ? ans.toString() : "IMPOSSIBLE";
    }
}

public class Example20241223_q1 {
    public static String Example20241223_q1(int m, int n, String[] board) {
        List<String> boards = Arrays.asList(board);
        List<List<AInfo>> arr = new ArrayList<>(26);
        int pairCount = 0;

        for (int i = 0; i < 26; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if ('A' <= c && c <= 'Z') {
                    arr.get(c - 'A').add(new AInfo(i, j));
                    pairCount++;
                }
            }
        }

        // Strategy pattern 적용: BFS 경로 찾기
        PathFindingStrategy bfsStrategy = new BFSPathFinding();
        PuzzleSolver solver = new PuzzleSolver(bfsStrategy);
        BoardState boardState = new BoardState(boards, pairCount);

        return solver.solve(arr, boardState);
    }
}
