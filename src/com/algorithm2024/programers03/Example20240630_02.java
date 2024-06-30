package com.algorithm2024.programers03;


import java.util.*;

public class Example20240630_02 { //신고 결과받기 2022 KAKAO BLIND RECRUITMENT
    public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, Set<String>> reportedMap = new HashMap<>();
            Map<String, Integer> idxMap = new HashMap<>();

            for (int i = 0; i < id_list.length; i++) {
                reportedMap.put(id_list[i], new HashSet<>());
                idxMap.put(id_list[i], i);
            }

            for (String r : report) {
                String[] parts = r.split(" ");
                reportedMap.get(parts[1]).add(parts[0]);
            }

            for (String id : id_list) {
                Set<String> reporters = reportedMap.get(id);
                if (reporters.size() >= k) {
                    for (String reporter : reporters) {
                        answer[idxMap.get(reporter)]++;
                    }
                }
            }
            return answer;
        }

}
