package com.jababookbackjoon3;

import java.util.Arrays;
import java.util.Scanner;

public class Example20240408_q2304 {

    static class Node {
        int point;
        int height;

        public Node(final int point, final int height) {
            this.point = point;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int maxHeight = 0;
        int maxIndex = 0;
        int startPoint = Integer.MAX_VALUE;
        int endPoint = Integer.MIN_VALUE;

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int point = sc.nextInt();
            int height = sc.nextInt();

            startPoint = Math.min(startPoint, point);
            endPoint = Math.max(endPoint, point);


            nodes[i] = new Node(point, height);
        }

        Arrays.sort(nodes, (o1, o2) -> o1.point - o2.point);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].height > maxHeight) {
                maxHeight = nodes[i].height;
                maxIndex = i;
            }
        }


        int answer = 0;
        int maxTempHeight = nodes[0].height;
        int beforePoint = nodes[0].point;


        for (int i = 0; i <= maxIndex; i++) {
            Node node = nodes[i];

            if (maxTempHeight < node.height) {
                for (int j = beforePoint; j <= node.point - 1; j++) {
                    answer += maxTempHeight;
                }

                maxTempHeight = node.height;
                beforePoint = node.point;
            }
        }

        maxTempHeight = nodes[nodes.length - 1].height;
        beforePoint = nodes[nodes.length - 1].point;
        for (int i = n - 1; i >= maxIndex; i--) {
            Node node = nodes[i];

            if (node.height > maxTempHeight) {
                for (int j = beforePoint; j >= node.point + 1; j--) {
                    answer += maxTempHeight;
                }

                maxTempHeight = node.height;
                beforePoint = node.point;
            }
        }

        System.out.println(answer);
    }
}
