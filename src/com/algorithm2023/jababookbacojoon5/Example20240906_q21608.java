package com.algorithm2023.jababookbacojoon5;

import java.util.*;

public class Example20240906_q21608 {
    static int n;
    static List<Student> students;
    static int[][] map;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer;
    static Map<Integer, Student> database;

    static class Student {
        int id;
        List<Integer> likes = new ArrayList<>();

        public Student(final int id, int a, int b, int c, int d) {
            this.id = id;
            likes.addAll(List.of(a, b, c, d));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        students = new ArrayList<>();
        map = new int[n][n];
        answer = 0;
        database = new LinkedHashMap<>();

        for (int i = 0; i < n * n; i++) {
            Student student = new Student(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            students.add(student);
            database.put(student.id, student);
        }

        for (Student student : students) {
            setPosition(student);
        }

        answer = calculate();

        System.out.println(answer);
    }

    static int calculate() {
        int sum = 0;

        // 10 10 1
        // 10 0 10
        // 0 1 0

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int point = 0;

                Student now = database.get(map[i][j]);
                for (int[] po : pos) {
                    int nr = i + po[0];
                    int nc = j + po[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (now.likes.contains(map[nr][nc])) {
                            point++;
                        }
                    }
                }

                if (point == 1) {
                    sum += 1;
                } else if (point == 2) {
                    sum += 10;
                } else if (point == 3) {
                    sum += 100;
                } else if (point == 4) {
                    sum += 1000;
                }
            }
        }

        return sum;
    }

    static void setPosition(Student student) {
        List<int[]> emptyPosition = new ArrayList<>();

        // 1. 빈 자리 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    emptyPosition.add(new int[]{i, j});
                }
            }
        }

        // 2. 좋아하는 학생이 있는 자리에 앉히기
        int maxNearSeat = 0; // 앉을 수 있는 칸 주변 최대 선호학생 수
        for (int[] position : emptyPosition) {
            int temp = 0;

            for (int i = 0; i < pos.length; i++) {
                int nr = position[0] + pos[i][0];
                int nc = position[1] + pos[i][1];

                // 선호 학생이 있다면 ++
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (student.likes.contains(map[nr][nc])) {
                        temp++;
                    }
                }
            }

            if (temp > maxNearSeat) {
                maxNearSeat = temp;
            }
        }

        // 선호도 최고인 자리 찾기
        List<int[]> finalPosition = new ArrayList<>();
        for (int[] position : emptyPosition) {
            int temp = 0;

            for (int i = 0; i < pos.length; i++) {
                int nr = position[0] + pos[i][0];
                int nc = position[1] + pos[i][1];

                // 선호 학생이 있다면 ++
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (student.likes.contains(map[nr][nc])) {
                        temp++;
                    }
                }
            }

            if (temp == maxNearSeat) {
                finalPosition.add(position);
            }
        }

        // 3. 주변에 빈칸이 가장 많은 쪽으로 이동 시킨다.
        List<int[]> nearPositions = new ArrayList<>();
        int maxNearCount = 0;

        for (int[] position : finalPosition) {
            int temp = 0;

            for (int[] p : pos) {
                int nr = position[0] + p[0];
                int nc = position[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {
                    temp++;
                }
            }

            maxNearCount = Math.max(maxNearCount, temp);
        }

        for (int[] position : finalPosition) {
            int temp = 0;

            for (int[] p : pos) {
                int nr = position[0] + p[0];
                int nc = position[1] + p[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 0) {
                    temp++;
                }
            }

            if (temp == maxNearCount) {
                nearPositions.add(position);
            }
        }

        // 4. 여러 칸이면 row, col 순으로 앉히기
        nearPositions.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        int[] position = nearPositions.get(0);
        map[position[0]][position[1]] = student.id;
    }
}
