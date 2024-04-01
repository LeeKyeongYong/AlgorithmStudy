package com.algorithm2024.programers02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example20240401_3 {//표병합
    static String[] map;
    static int[] parents;

    public static String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        map = new String[2501];
        parents = new int[2501];

        for (int i = 0; i < map.length; i++) {
            map[i] = "";
            parents[i] = i;
        }

        for (String command : commands) {
            String[] split = command.split(" ");
            String order = split[0];

            if (order.equals("UPDATE")) {
                if (split.length == 4) {
                    int row = Integer.parseInt(split[1]);
                    int col = Integer.parseInt(split[2]);
                    String value = split[3];
                    int x = convert(row, col);
                    map[find(x)] = value; // 병합된 셀한테 값 전달
                    continue;
                } else if (split.length == 3) {
                    String before = split[1];
                    String after = split[2];
                    update(before, after);
                }
            }

            if (order.equals("MERGE")) {
                int sr = Integer.parseInt(split[1]);
                int sc = Integer.parseInt(split[2]);
                int nr = Integer.parseInt(split[3]);
                int nc = Integer.parseInt(split[4]);

                int posX = convert(sr, sc);
                int posY = convert(nr, nc);

                int parentX = find(posX);
                int parentY = find(posY);

                if (parentX == parentY) {
                    // 이미 병합된 경우
                    continue;
                }

                String rootValue = map[parentX].isBlank() ? map[parentY] : map[parentX];
                map[parentX] = "";
                map[parentY] = "";
                union(parentX, parentY);
                map[parentX] = rootValue;
                continue;
            }

            if (order.equals("UNMERGE")) {
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                int convertPos = convert(r, c);
                int parent = find(convertPos);
                String rootValue = map[parent];

                map[parent] = "";
                map[convertPos] = rootValue;

                List<Integer> deleted = new ArrayList<>();
                for (int i = 0; i < map.length; i++) {
                    if (find(i) == parent) {
                        deleted.add(i);
                    }
                }

                for (Integer i : deleted) {
                    // 표 분리
                    parents[i] = i;
                }

                continue;
            }

            if (order.equals("PRINT")) {
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                int convertPos = convert(r, c);
                int root = find(convertPos);

                if (map[root].isBlank()) {
                    answer.add("EMPTY");
                } else {
                    answer.add(map[root]);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    static int convert(int row, int col) {
        // 1, 1 -> 1
        // 2, 1 -> 51
        // 50, 50 -> 2500
        return 50 * (row - 1) + col;
    }

    static void update(String before, String after) {
        for (int i = 0; i < map.length; i++) {
            if (map[i].equals(before)) {
                map[i] = after;
            }
        }
    }

    static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            parents[fy] = fx;
        }
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return find(parents[x]);
    }


    public static void main(String[] args) {
        String[] com = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        // ["EMPTY", "group"]
        System.out.println(Arrays.toString(solution(com)));
    }
}
