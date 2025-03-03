package com.algorithm2023.jababookbackjoon3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example20240407_q14226 {
    // clip, total
    static boolean[][] visited = new boolean[1001][1001];

    public static class Node {

        int clip;
        int total;
        int time;

        public Node(int clip, int total, int time) {
            this.clip = clip;
            this.total = total;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();
            int clip = current.clip;
            int total = current.total;
            int time = current.time;

            if (total == s) {
                System.out.println(time);
                return;
            }

            // 1. 클립에 복사해둔다
            q.offer(new Node(total, total, time + 1));


            // 2. 클립의 내용을 붙여넣는다.
            // 클립이 존재해야하고, 클립 + 현재 <= S 여야하고, 방문한 적이 없어야한다
            if (clip != 0 && total + clip <= s && !visited[clip][total + clip]) {
                q.offer(new Node(clip, total + clip, time + 1));
                visited[clip][total + clip] = true;
            }

            // 3. 이모티콘 삭제
            // 이모티콘이 1보다 커야하고 방문한 적 없어야함
            if (total >= 1 && !visited[clip][total - 1]) {
                q.offer(new Node(clip, total - 1, time + 1));
                visited[clip][total - 1] = true;
            }
        }
    }
}
