package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.List;

public class Example20240708_06 { //2023 KAKAO BLIND RECRUITMENT 표 병합

    private static class Cell {
        int r, c;
        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private Cell[][] parent = new Cell[51][51];
    private String[][] cells = new String[51][51];
    private List<String> result = new ArrayList<>();

    public Example20240708_06() {
        for (int r = 0; r < 51; r++) {
            for (int c = 0; c < 51; c++) {
                parent[r][c] = new Cell(r, c);
                cells[r][c] = "EMPTY";
            }
        }
    }

    private Cell find(int r, int c) {
        if (parent[r][c].r == r && parent[r][c].c == c) {
            return parent[r][c];
        }
        parent[r][c] = find(parent[r][c].r, parent[r][c].c);
        return parent[r][c];
    }

    private void union(int r1, int c1, int r2, int c2) {
        parent[r2][c2] = parent[r1][c1];
    }

    private void update(int r, int c, String msg) {
        Cell p = find(r, c);
        cells[p.r][p.c] = msg;
    }

    private void updateVal(String msg1, String msg2) {
        for (int r = 0; r < 51; r++) {
            for (int c = 0; c < 51; c++) {
                Cell p = find(r, c);
                if (cells[p.r][p.c].equals(msg1)) {
                    cells[p.r][p.c] = msg2;
                }
            }
        }
    }

    private void merge(int r1, int c1, int r2, int c2) {
        Cell p1 = find(r1, c1);
        Cell p2 = find(r2, c2);

        if (p1.r == p2.r && p1.c == p2.c) {
            return;
        }
        if (!cells[p1.r][p1.c].equals("EMPTY")) {
            union(p1.r, p1.c, p2.r, p2.c);
        } else {
            union(p2.r, p2.c, p1.r, p1.c);
        }
    }

    private void unmerge(int r, int c) {
        Cell p = find(r, c);
        String msg = cells[p.r][p.c];

        List<Cell> mergeList = new ArrayList<>();
        for (int ar = 0; ar < 51; ar++) {
            for (int ac = 0; ac < 51; ac++) {
                Cell ap = find(ar, ac);
                if (ap.r == p.r && ap.c == p.c) {
                    mergeList.add(new Cell(ar, ac));
                }
            }
        }

        for (Cell cell : mergeList) {
            parent[cell.r][cell.c] = new Cell(cell.r, cell.c);
            cells[cell.r][cell.c] = (cell.r == r && cell.c == c) ? msg : "EMPTY";
        }
    }

    private void print(int r, int c) {
        Cell p = find(r, c);
        result.add(cells[p.r][p.c]);
    }

    public List<String> solution(String[] commands) {
        for (String command : commands) {
            String[] args = command.split(" ");
            String cmd = args[0];
            if (cmd.equals("UPDATE")) {
                if (args.length == 4) {
                    int r = Integer.parseInt(args[1]);
                    int c = Integer.parseInt(args[2]);
                    String value = args[3];
                    update(r, c, value);
                } else {
                    String value1 = args[1];
                    String value2 = args[2];
                    updateVal(value1, value2);
                }
            } else if (cmd.equals("MERGE")) {
                int r1 = Integer.parseInt(args[1]);
                int c1 = Integer.parseInt(args[2]);
                int r2 = Integer.parseInt(args[3]);
                int c2 = Integer.parseInt(args[4]);
                merge(r1, c1, r2, c2);
            } else if (cmd.equals("UNMERGE")) {
                int r = Integer.parseInt(args[1]);
                int c = Integer.parseInt(args[2]);
                unmerge(r, c);
            } else if (cmd.equals("PRINT")) {
                int r = Integer.parseInt(args[1]);
                int c = Integer.parseInt(args[2]);
                print(r, c);
            }
        }
        return result;
    }

}
