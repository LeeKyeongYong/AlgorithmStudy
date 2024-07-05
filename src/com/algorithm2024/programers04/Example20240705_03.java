package com.algorithm2024.programers04;

import java.util.*;

public class Example20240705_03 { //  2017 카카오코드 본선 리틀 프렌즈 사천성

    private static int pairCnt = 0;
    private static int N = 0, M = 0;

    private static class QInfo {
        int x, y, dir, cnt;

        QInfo(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    private static class AInfo {
        int x, y;

        AInfo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < M && 0 <= y && y < N);
    }

    private static boolean BFS(int start_x, int start_y, int end_x, int end_y, List<String> boards) {
        int[][] nextdir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<QInfo> q = new LinkedList<>();

        q.add(new QInfo(start_x, start_y, -1, 0));

        while (!q.isEmpty()) {
            QInfo current = q.poll();
            int now_x = current.x;
            int now_y = current.y;
            int cnt = current.cnt;
            int dir = current.dir;

            for (int i = 0; i < 4; i++) {
                if (dir != -1 && Math.abs(dir - i) == 2)
                    continue;

                int next_x = now_x + nextdir[i][0];
                int next_y = now_y + nextdir[i][1];
                int next_cnt = (dir == i || dir == -1) ? cnt : cnt + 1;

                if (inRange(next_x, next_y)) {
                    if (next_cnt <= 1) {
                        char nextChar = boards.get(next_x).charAt(next_y);
                        if (nextChar == '*') {
                            continue;
                        } else if (nextChar == '.') {
                            q.add(new QInfo(next_x, next_y, i, next_cnt));
                        } else {
                            if (next_x == end_x && next_y == end_y)
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static String solve(List<List<AInfo>> arr, List<String> boards) {
        StringBuilder ans = new StringBuilder();
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).size() > 1) {
                    AInfo start = arr.get(i).get(0);
                    AInfo end = arr.get(i).get(1);
                    if (BFS(start.x, start.y, end.x, end.y, boards)) {
                        boards.set(start.x, boards.get(start.x).substring(0, start.y) + '.' + boards.get(start.x).substring(start.y + 1));
                        boards.set(end.x, boards.get(end.x).substring(0, end.y) + '.' + boards.get(end.x).substring(end.y + 1));
                        arr.get(i).clear();
                        pairCnt -= 2;
                        ans.append((char) (i + 'A'));
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (pairCnt == 0)
            return ans.toString();
        else
            return "IMPOSSIBLE";
    }

    public static String solution(int m, int n, String[] board) {
        M = m;
        N = n;
        pairCnt = 0;
        List<String> boards = Arrays.asList(board);
        List<List<AInfo>> arr = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if ('A' <= c && c <= 'Z') {
                    arr.get(c - 'A').add(new AInfo(i, j));
                    pairCnt++;
                }
            }
        }

        return solve(arr, boards);
    }

}
