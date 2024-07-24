package com.algorithm2024.programers04;

import java.util.*;

public class Example20240724_01 { //2021 KAKAO BLIND RECRUITMENT 순위 검색

    public static List<Integer> solution(String[] information, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        // 정보를 입력받아 맵에 저장
        for (String info : information) {
            String[] parts = info.split(" ");
            String[] condition = Arrays.copyOf(parts, 4);
            int score = Integer.parseInt(parts[4]);
            // 모든 가능한 조합에 대해 처리
            for (int i = 0; i <= 4; i++) {
                List<List<Integer>> combinations = getCombinations(Arrays.asList(0, 1, 2, 3), i);
                for (List<Integer> combo : combinations) {
                    String[] temp = condition.clone();
                    for (int index : combo) {
                        temp[index] = "-";
                    }
                    String key = String.join("", temp);
                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(score);
                }
            }
        }

        // 각 조건별로 점수를 정렬
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        // 쿼리 처리
        for (String query : queries) {
            query = query.replace("and ", "");
            String[] queryParts = query.split(" ");
            String targetKey = String.join("", Arrays.copyOf(queryParts, queryParts.length - 1));
            int targetScore = Integer.parseInt(queryParts[queryParts.length - 1]);
            int count = 0;
            if (map.containsKey(targetKey)) {
                List<Integer> targetList = map.get(targetKey);
                count = targetList.size() - binarySearch(targetList, targetScore);
            }
            answer.add(count);
        }

        return answer;
    }

    // 주어진 리스트에서 값을 찾아 반환하는 이진 탐색 함수
    private static int binarySearch(List<Integer> list, int value) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // 주어진 리스트에서 조합을 생성하는 함수
    private static List<List<Integer>> getCombinations(List<Integer> elements, int size) {
        List<List<Integer>> result = new ArrayList<>();
        if (size == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        if (elements.isEmpty()) {
            return result;
        }
        Integer first = elements.get(0);
        List<Integer> rest = elements.subList(1, elements.size());

        // 포함된 조합
        for (List<Integer> combination : getCombinations(rest, size - 1)) {
            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(0, first);
            result.add(newCombination);
        }

        // 포함되지 않은 조합
        result.addAll(getCombinations(rest, size));

        return result;
    }

}
