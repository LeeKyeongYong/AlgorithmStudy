package com.algorithm2024.letcode;

import java.util.*;

public class Example20240229_q49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedStr = String.valueOf(temp);

            map.putIfAbsent(sortedStr, new ArrayList<String>());
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * // FAIL(MEMORY) BACKTRACKS
     *
     *     static List<List<String>> answer;
     *     static int n;
     *     static boolean[] visited;
     *
     *     public List<List<String>> groupAnagrams(String[] strs) {
     *         answer = new ArrayList<>();
     *         n = strs.length;
     *         visited = new boolean[n];
     *
     *         for (int i = 0; i < strs.length; i++) {
     *             if (visited[i]) {
     *                 continue;
     *             }
     *
     *             String str = strs[i];
     *             List<String> list = new ArrayList<>();
     *             Map<Character, Integer> map = new HashMap<>();
     *             for (char c : str.toCharArray()) {
     *                 map.put(c, map.getOrDefault(c, 0) + 1);
     *             }
     *
     *             list.add(str);
     *             visited[i] = true;
     *             permutation(str, list, strs, map);
     *             answer.add(list);
     *         }
     *
     *         return answer;
     *     }
     *
     *     static void permutation(final String str, final List<String> list, final String[] strs, final Map<Character, Integer> map) {
     *         for (int i = 0; i < n; i++) {
     *             if (visited[i]) {
     *                 continue;
     *             }
     *
     *             String node = strs[i];
     *             boolean isContinue = false;
     *
     *             HashMap<Character, Integer> copyMap = new HashMap<>(map);
     *
     *             for (char c : node.toCharArray()) {
     *                 if (!copyMap.containsKey(c)) {
     *                     isContinue = true;
     *                     break;
     *                 }
     *
     *                 copyMap.put(c, copyMap.get(c) - 1);
     *                 if (copyMap.get(c) == 0) {
     *                     copyMap.remove(c);
     *                 }
     *             }
     *
     *             if (isContinue) {
     *                 continue;
     *             }
     *
     *             if (copyMap.keySet().isEmpty()) {
     *                 visited[i] = true;
     *                 list.add(strs[i]);
     *             }
     *         }
     *     }
     */

    public static void main(String[] args) {
        Example20240229_q49 sol = new Example20240229_q49();

        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        // [["tittt","tttit","tttti"],["hhhhu","hhhuh","hhuhh"]]
        System.out.println(sol.groupAnagrams(new String[]{"hhhhu", "tttti", "tttit", "hhhuh", "hhuhh", "tittt"}));
    }
}
