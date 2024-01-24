package com.algorithm2024.programers01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exam2040124 {
    public static void main(String[] args) {
        // Example usage
        List<String> friends = Arrays.asList("A", "B", "C");
        List<String> gifts = Arrays.asList("A B", "B C", "C A");
        Solution01 s1 = new Solution01();
        int result = s1.solution(friends, gifts);
        System.out.println("가장 많이 받은 선물: " + result);
    }
}

class Solution01 {

    static Map<String, Integer> FM;
    static List<List<Integer>> graph;
    static List<Integer> giftScore;

    Solution01() {
        FM = new HashMap<>();
        graph = new ArrayList<>();
        giftScore = new ArrayList<>();
    }

    static void splitFunc(String str) {
        String[] ans = str.split(" ");
        graph.get(FM.get(ans[0])).set(FM.get(ans[1]), graph.get(FM.get(ans[0])).get(FM.get(ans[1])) + 1);
        graph.get(FM.get(ans[1])).set(FM.get(ans[0]), graph.get(FM.get(ans[1])).get(FM.get(ans[0])) - 1);
        giftScore.set(FM.get(ans[0]), giftScore.get(FM.get(ans[0])) + 1);
        giftScore.set(FM.get(ans[1]), giftScore.get(FM.get(ans[1])) - 1);
    }

    public int solution(List<String> friends, List<String> gifts) {
        int answer = 0;
        giftScore = new ArrayList<>(friends.size());
        for (int i = 0; i < friends.size(); i++) {
            FM.put(friends.get(i), i);
        }
        graph = new ArrayList<>(friends.size());
        for (int i = 0; i < friends.size(); i++) {
            graph.add(new ArrayList<>(Collections.nCopies(friends.size(), 0)));
            for (int j = 0; j < friends.size(); j++) {
                graph.get(i).set(j, 0);
            }
        }
        for (int i = 0; i < gifts.size(); i++) {
            splitFunc(gifts.get(i));
        }

        for (int i = 0; i < friends.size(); i++) {
            int nowGift = 0;
            for (int j = 0; j < friends.size(); j++) {
                if (graph.get(i).get(j) > 0) {
                    nowGift += 1;
                } else if (graph.get(i).get(j) == 0) {
                    if (giftScore.get(i) > giftScore.get(j)) {
                        nowGift += 1;
                    }
                }
            }
            if (nowGift > answer) {
                answer = nowGift;
            }
        }
        return answer;
    }
}