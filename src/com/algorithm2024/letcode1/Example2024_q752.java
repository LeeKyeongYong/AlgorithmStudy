package com.algorithm2024.letcode1;

import java.util.*;

public class Example2024_q752 {

    static class Lock {
        String lock;
        int count;

        public Lock(final String lock, final int count) {
            this.lock = lock;
            this.count = count;
        }
    }

    public static int openLock(String[] deadends, String target) {
        Queue<Lock> q = new LinkedList<>();
        q.add(new Lock("0000", 0));

        List<String> deads = List.of(deadends);
        if (deads.contains("0000")) {
            return -1;
        }

        int answer = -1;

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while (!q.isEmpty()) {
            Lock now = q.poll();
            String locks = now.lock;

            if (deads.contains(now)) {
                continue;
            }

            if (now.lock.equals(target)) {
                answer = now.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                for (int pos : new int[]{-1, 1}) {
                    int newChar = (locks.charAt(i) - '0' + pos + 10) % 10;

                    String next = locks.substring(0, i) + newChar + locks.substring(i + 1);

                    if (!visited.contains(next) && !deads.contains(next)) {
                        visited.add(next);
                        q.offer(new Lock(next, now.count + 1));
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";

        // 6
        System.out.println(openLock(deadends, target));
    }
}
