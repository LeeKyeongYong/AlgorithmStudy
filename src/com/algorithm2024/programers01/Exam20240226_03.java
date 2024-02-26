package com.algorithm2024.programers01;

public class Exam20240226_03 {//미로탈출_그리디

    enum ENUM_DIR {d, l, r, u}

    // D L R U
    static final int[][] pos = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();

        if ((getDistanceToDestination(x, y, r, c) % 2 == 0) != (k % 2 == 0) || getDistanceToDestination(x, y, r, c) > k) {
            return "impossible";
        }

        // 사전순대로 이동
        while (getDistanceToDestination(x, y, r, c) != k && k > 0) {
            k--;

            for (int i = 0; i < pos.length; i++) {
                x += pos[i][0];
                y += pos[i][1];

                if (x > 0 && y > 0 && x <= n && y <= m) {
                    sb.append(ENUM_DIR.values()[i]);
                    break;
                } else {
                    x -= pos[i][0];
                    y -= pos[i][1];
                }
            }
        }

        while (x != r || y != c) {
            k--;

            for (int i = 0; i < pos.length; i++) {
                x += pos[i][0];
                y += pos[i][1];

                if (x > 0 && y > 0 && x <= n && y <= m && getDistanceToDestination(x, y, r, c) == k) {
                    sb.append(ENUM_DIR.values()[i]);
                    break;
                } else {
                    x -= pos[i][0];
                    y -= pos[i][1];
                }
            }
        }

        return sb.toString();
    }

    static int getDistanceToDestination(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }

    public static void main(String[] args) {
        // dllrl
//        System.out.println(solution(3, 4, 2, 3, 3, 1, 5));

        // dr
        System.out.println(solution(2, 2, 1, 1, 2, 2, 2));
    }
}
