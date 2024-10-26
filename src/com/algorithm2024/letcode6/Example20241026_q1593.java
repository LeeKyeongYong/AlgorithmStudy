package com.algorithm2024.letcode6;

import java.util.HashSet;
import java.util.Set;

public class Example20241026_q1593 {

    private static Set<String> set;

    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        return dfs(0, s);
    }

    private int dfs(int start, String s) {
        if (start == s.length()) {
            return 0;
        }

        int maxCount = 0;

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (!set.contains(sub)) {
                set.add(sub);
                maxCount = Math.max(maxCount, 1 + dfs(end, s));
                set.remove(sub);
            }
        }

        return maxCount;
    }

}
