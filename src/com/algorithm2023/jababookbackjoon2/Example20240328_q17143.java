package com.algorithm2023.jababookbackjoon2;

import java.util.*;

public class Example20240328_q17143 {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static List<Shark> sharks;
    static int answer;

    static class Position {
        int row;
        int col;

        public Position(final int row, final int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (!(o instanceof Position position)) return false;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class Shark {
        int row;
        int col;
        int speed;
        int dir;
        int size;

        public Shark(final int row, final int col, final int speed, final int dir, final int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        public void move() {
            int count = speed;

            while (count > 0) {
                if (dir == 1) {
                    // 위인 경우
                    count--;
                    int afterRow = this.row - 1;
                    if (afterRow >= 0 && afterRow < n) {
                        this.row = afterRow;
                    } else {
                        this.row = 1;
                        this.dir = 2;
                    }
                }

                if (dir == 2) {
                    // 아래인 경우
                    count--;
                    int afterRow = this.row + 1;
                    if (afterRow >= 0 && afterRow < n) {
                        this.row = afterRow;
                    } else {
                        this.row = n - 2;
                        this.dir = 1;
                    }
                }

                if (dir == 3) {
                    // 오른쪽인 경우
                    count--;
                    int afterColumn = this.col + 1;
                    if (afterColumn >= 0 && afterColumn < m) {
                        this.col = afterColumn;
                    } else {
                        this.col = m - 2;
                        this.dir = 4;
                    }
                }

                // 0 1 2 3 4 5

                if (dir == 4) {
                    // 왼쪽인 경우
                    count--;
                    int afterColumn = this.col - 1;
                    if (afterColumn >= 0 && afterColumn < m) {
                        this.col = afterColumn;
                    } else {
                        this.col = 1;
                        this.dir = 3;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        sharks = new ArrayList<>();
        answer = 0;

        map = new int[n][m];
        for (int i = 0; i < k; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            int speed = sc.nextInt();
            int dir = sc.nextInt();
            int size = sc.nextInt();

            sharks.add(new Shark(row, col, speed, dir, size));
        }

        int column = -1;
        while (true) {
            // 1. 좌표 이동
            column++;
            if (column == m) {
                break;
            }

            // 2. 제일 땅과 가까운 상어를 잡는다 (잡으면 제거)
            catchShark(column);

            // 3. 상어 이동
            moveShark();
        }

        System.out.println(answer);
    }

    static void moveShark() {
        Map<Position, List<Shark>> map = new HashMap<>();

        // 1. 상어들을 이동시키고 map에 넣는다
        for (Shark shark : sharks) {
            shark.move();
            int row = shark.row;
            int col = shark.col;

            if (!map.containsKey(new Position(row, col))) {
                map.put(new Position(row, col), new ArrayList<>());
            }

            List<Shark> temp = map.get(new Position(row, col));
            if (!temp.isEmpty()) {
                // 이미 존재한다면
                Shark alreadBeenShark = temp.get(0);
                if (alreadBeenShark.size < shark.size) {
                    // 새로온 상어가 더 크다면
                    List<Shark> list = new ArrayList<>();
                    list.add(shark);
                    map.put(new Position(row, col), list);
                }
            }
        }

        // 2. 상어를 배치한다
        for (Position pos : map.keySet()) {
            if (map.get(pos).size() >= 2) {
                // 상어가 여러마리인 경우 한 마리만 남긴다
                Shark maxShark = null;
                int max = 0;

                for (Shark shark : map.get(pos)) {
                    if (shark.size > max) {
                        max = shark.size;
                        maxShark = shark;
                    }
                }

                for (Shark shark : map.get(pos)) {
                    if (!shark.equals(shark)) {
                        sharks.remove(shark);
                    }
                }
            }
        }
    }

    static void catchShark(int col) {
        int[][] map = new int[n][m];
        Map<Position, Shark> position = new HashMap<>();

        for (Shark shark : sharks) {
            map[shark.row][shark.col] = 1;
            position.put(new Position(shark.row, shark.col), shark);
        }

        for (int i = 0; i < n; i++) {
            if (map[i][col] == 1) {
                Shark shark = position.get(new Position(i, col));
                sharks.remove(shark);
                map[i][col] = 0;
                answer += shark.size;
                break;
            }
        }

//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println(col + " " + answer);
//        System.out.println();
    }
}
