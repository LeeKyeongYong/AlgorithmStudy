package com.algorithm2024.letcode5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example20240802_q14499 {

    static int m;
    static int n;
    static int diceRow;
    static int diceCol;
    static int[][] map;
    static int[] dice = new int[7];
    static int[][] POS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        diceCol = Integer.parseInt(st.nextToken());
        diceRow = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());
            move(d);
        }

    }

    static void move(int pos) {
        int nr = diceRow + POS[pos - 1][0];
        int nc = diceCol + POS[pos - 1][1];

        if (nr < 0 || nc < 0 || nr > n - 1 || nc > m - 1) {
            return;
        }

        approve(pos, nr, nc);
        diceRow = nr;
        diceCol = nc;

    }

    static void approve(int pos, int row, int col) {
        int temp = dice[3];

        if (pos == 1) {
            dice[3] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        } else if (pos == 2) {
            dice[3] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        } else if (pos == 3) {
            dice[3] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[1];
            dice[1] = temp;
        } else if (pos == 4) {
            dice[3] = dice[1];
            dice[1] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }

        if (map[col][row] == 0) {
            map[col][row] = dice[6];
        } else {
            dice[6] = map[col][row];
            map[col][row] = 0;
        }

        System.out.println(dice[3]);
    }
}