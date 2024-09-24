package com.algorithm2024.letcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Exam20240924_q787 {
    static ArrayList<Exam20240924_q787.Node>[] list;
    static int[] dp;

    class Node {

        int dest;
        int cost;

        public Node(final int dest, final int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        list = new ArrayList[n];
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int cost = flight[2];
            list[start].add(new Exam20240924_q787.Node(end, cost));
        }

        Queue<Exam20240924_q787.Node> pq = new ArrayDeque<>();
        pq.add(new Exam20240924_q787.Node(src, 0));

        dp[src] = 0;

        int step = 0;
        while (!pq.isEmpty() && step <= k) {
            int size = pq.size();

            while (size-- > 0) {
                Exam20240924_q787.Node now = pq.poll();

                for (Exam20240924_q787.Node next : list[now.dest]) {
                    if (dp[next.dest] > now.cost + next.cost) {
                        dp[next.dest] = now.cost + next.cost;
                        pq.offer(new Exam20240924_q787.Node(next.dest, dp[next.dest]));
                    }
                }
            }

            step++;
        }


        if (dp[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[dst];
    }

    public static void main(String[] args) {
        Exam20240924_q787 sol = new Exam20240924_q787();

        // 700
        System.out.println(sol.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));

        // 7
        System.out.println(sol.findCheapestPrice(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2));
    }
}