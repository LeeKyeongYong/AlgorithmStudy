package com.algorithm2024.letcode2;

import java.util.HashMap;

public class Example20240518_q525 {
    // prefix O(N)
    public static int findMaxLength(int[] nums) {
        // sum, index
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += getNum(nums[i]);

            // 0번째 인덱스부터 지금까지 총 합 0
            if (sum == 0) {
                answer = i + 1;
                continue;
            }

            // 같은 값이 있다면, 두 인덱스 사이에 0과 1의 수가 같으니 현재 정답과 지금까지 합을 비교한다
            if (map.containsKey(sum)) {
                answer = Math.max(answer, i - map.get(sum));
                continue;
            }

            // 처음보는 sum 값이면 삽입
            map.put(sum, i);
        }

        return answer;
    }

    private static int getNum(int num) {
        if (num == 0) {
            return -1;
        }

        return 1;
    }


//    TLE : 완탐 O(n^2)
//    public static int findMaxLength(int[] nums) {
//        int answer = 0;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            int num = getNum(nums[i]);
//            for (int j = i + 1; j < nums.length; j++) {
//                num += getNum(nums[j]);
//
//                if (num == 0) {
//                    answer = Math.max(answer, j - i + 1);
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    private static int getNum(int num) {
//        if (num == 0) {
//            return -1;
//        }
//
//        return 1;
//    }

    public static void main(String[] args) {
        // 4
        System.out.println(findMaxLength(new int[]{1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0}));

        // 2
//        System.out.println(findMaxLength(new int[]{1, 0}));
    }
}
