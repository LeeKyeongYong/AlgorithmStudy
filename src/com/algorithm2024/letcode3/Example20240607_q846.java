package com.algorithm2024.letcode3;


import java.util.*;

public class Example20240607_q846 {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);

        if (hand.length % groupSize != 0) {
            return false;
        }

        for (int j : hand) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        while (!map.isEmpty()) {
            // 중간 연산에서 중간 키가 삭제 될 수 있으므로 iterator 선택
            int now = map.entrySet().iterator().next().getKey();

            for (int i = 0; i < groupSize; i++) {
                // sequence 가 아니면 false;
                if (!map.containsKey(now + i)) {
                    return false;
                }

                // sequence 이므로 다음 숫자의 수량 1개 감소
                map.put(now + i, map.get(now + i) - 1);

                // 수량이 없다면 map에서 제거
                if (map.get(now + i) == 0) {
                    map.remove(now + i);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }
}
