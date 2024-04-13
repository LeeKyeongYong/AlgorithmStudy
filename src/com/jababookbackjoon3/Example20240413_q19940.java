package com.jababookbackjoon3;

public class Example20240413_q19940 {
    static class Node {
        int pos;
        int value;
        int v1;
        int v2;
        int v3;
        int v4;
        int v5;

        public Node(final int pos, final int value, final int v1, final int v2, final int v3, final int v4, final int v5) {
            this.pos = pos;
            this.value = value;
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
            this.v4 = v4;
            this.v5 = v5;
        }

        public void addV1() {
            this.v1++;
        }

        public void addV2() {
            this.v2++;
        }

        public void addV3() {
            this.v3++;
        }

        public void addV4() {
            this.v4++;
        }

        public void addV5() {
            this.v5++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve(sc.nextInt());
        }
    }

    static void solve(int num) {
        int max = 100000000;
        boolean[] visited = new boolean[max];

        visited[num] = true;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 0, 0, 0, 0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.pos == num) {
                System.out.println(now.v1 + " " + now.v2 + " " + now.v3 + " " + now.v4 + " " + now.v5);
                break;
            }

            if (now.pos + 60 <= max && !visited[now.pos + 60]) {
                Node node = new Node(now.pos + 60, now.value + 1, now.v1, now.v2, now.v3, now.v4, now.v5);
                node.addV1();
                q.add(node);
            }

            if (now.pos + 10 <= max && !visited[now.pos + 10]) {
                Node node = new Node(now.pos + 10, now.value + 1, now.v1, now.v2, now.v3, now.v4, now.v5);
                node.addV2();
                q.add(node);
            }

            if (now.pos - 10 >= 0 && !visited[now.pos - 10]) {
                Node node = new Node(now.pos - 10, now.value + 1, now.v1, now.v2, now.v3, now.v4, now.v5);
                node.addV3();
                q.add(node);
            }

            if (now.pos + 1 <= max && !visited[now.pos + 1]) {
                Node node = new Node(now.pos + 1, now.value + 1, now.v1, now.v2, now.v3, now.v4, now.v5);
                node.addV4();
                q.add(node);
            }

            if (now.pos - 1 >= 0 && !visited[now.pos]) {
                Node node = new Node(now.pos - 1, now.value + 1, now.v1, now.v2, now.v3, now.v4, now.v5);
                node.addV5();
                q.add(node);
            }
        }
    }
}
