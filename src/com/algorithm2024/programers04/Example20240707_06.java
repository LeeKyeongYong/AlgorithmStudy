package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example20240707_06 { //2020 KAKAO BLIND RECRUITMENT 외벽 점검

    // Method to generate permutations of a given list up to length n
    private static List<List<Integer>> getPermutation(List<Integer> arr, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 1) {
            for (Integer num : arr) {
                result.add(new ArrayList<>(Collections.singletonList(num)));
            }
            return result;
        }

        for (int i = 0; i < arr.size(); i++) {
            List<Integer> rest = new ArrayList<>(arr);
            rest.remove(i);
            List<List<Integer>> perms = getPermutation(rest, n - 1);
            for (List<Integer> perm : perms) {
                List<Integer> attached = new ArrayList<>();
                attached.add(arr.get(i));
                attached.addAll(perm);
                result.add(attached);
            }
        }

        return result;
    }

    public static int solution(int n, int[] weak, int[] dist) {
        int weakLen = weak.length;
        int[] linearWeak = new int[weakLen * 2];

        for (int i = 0; i < weakLen * 2; i++) {
            if (i < weakLen) {
                linearWeak[i] = weak[i];
            } else {
                linearWeak[i] = n + weak[i - weakLen];
            }
        }

        // Sort dist array in descending order
        Arrays.sort(dist);
        for (int i = 0; i < dist.length / 2; i++) {
            int temp = dist[i];
            dist[i] = dist[dist.length - 1 - i];
            dist[dist.length - 1 - i] = temp;
        }

        // Iterate over the length of friends to use from 1 to dist.length
        for (int i = 1; i <= dist.length; i++) {
            List<List<Integer>> permutations = getPermutation(Arrays.asList(Arrays.stream(dist).boxed().toArray(Integer[]::new)), i);
            for (List<Integer> perm : permutations) {
                for (int j = 0; j < weakLen; j++) {
                    List<Integer> line = new ArrayList<>();
                    for (int k = j; k < weakLen + j; k++) {
                        line.add(linearWeak[k]);
                    }

                    boolean allCovered = true;
                    for (Integer p : perm) {
                        int start = line.get(0);
                        line.removeIf(e -> e <= start + p);
                        if (line.isEmpty()) {
                            return i;
                        }
                    }
                }
            }
        }

        return -1;
    }

}
