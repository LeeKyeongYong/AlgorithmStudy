package com.algorithm2025.backjoon2.day012;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Example20250323_Q49190 { //코딩테스트 연습 그래프  방의 개수

    private enum Direction {
        UP(0, 1), UP_RIGHT(1, 1), RIGHT(1, 0), DOWN_RIGHT(1, -1),
        DOWN(0, -1), DOWN_LEFT(-1, -1), LEFT(-1, 0), UP_LEFT(-1, 1);

        final int dx, dy;
        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        static Direction fromIndex(int index) {
            return values()[index];
        }
    }

    public int Example20250323_Q49190(int[] arrows) {
        int answer = 0;
        Map<Pair, Set<Pair>> visit = new HashMap<>();
        Pair current = new Pair(0, 0);
        visit.put(current, new HashSet<>()); // 초기 위치 방문 등록

        for (int arrow : arrows) {
            Direction dir = Direction.fromIndex(arrow);
            for (int i = 0; i < 2; i++) { // 한 칸씩 두 번 이동
                Pair next = new Pair(current.x + dir.dx, current.y + dir.dy);

                if (visit.containsKey(next)) {
                    if (!visit.get(next).contains(current)) answer++; // 새로운 경로일 때만 카운트 증가
                } else {
                    visit.put(next, new HashSet<>());
                }

                visit.get(current).add(next);
                visit.get(next).add(current);
                current = next;
            }
        }
        return answer;
    }

    private record Pair(int x, int y) {}

}
