package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240716_01 { //2018 KAKAO BLIND RECRUITMENT [3차] 압축


    private static int num = 1;
    private static Map<String, Integer> dict = new HashMap<>();

    private static void makeDefaultDictionary() {
        for (char c = 'A'; c <= 'Z'; c++) {
            String str = "" + c;
            dict.put(str, num++);
        }
    }

    private static void compression(String str, List<Integer> answer) {
        String cur = "";
        for (int i = 0; i < str.length(); i++) {
            cur += str.charAt(i);
            if (!dict.containsKey(cur)) {
                dict.put(cur, num++);
                cur = cur.substring(0, cur.length() - 1);
                answer.add(dict.get(cur));
                cur = "";
                i--;
            }
        }
        answer.add(dict.get(cur));
    }

    public static List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        makeDefaultDictionary();
        compression(msg, answer);
        return answer;
    }

    public static void main(String[] args) {
        // Test the function with the given examples
        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        System.out.println(solution(msg1)); // Output: [11, 1, 27, 15]
        System.out.println(solution(msg2)); // Output: [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        System.out.println(solution(msg3)); // Output: [1, 2, 27, 29, 28, 31, 30]
    }

}
