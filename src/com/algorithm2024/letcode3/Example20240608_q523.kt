package com.algorithm2024.letcode3

class Example20240608_q523 {

    public static boolean checkSubarraySum(int[] nums, int k) {
        // 0 23 25 31 35 42 // 6
        int prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % k;
            System.out.println(prefix);
            // 5 1 1 5 0 true

            if (map.containsKey(prefix)) {
                if (i - map.get(prefix) > 1) {
                    return true;
                }
            } else {
                map.put(prefix, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // true
        System.out.println(checkSubarraySum(
            new int[]{23, 2, 6, 4, 7},
            6
        ));
    }

}