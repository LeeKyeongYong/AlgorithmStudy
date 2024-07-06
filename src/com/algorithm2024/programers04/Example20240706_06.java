package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example20240706_06 { //2019 카카오 개발자 겨울 인턴십 불량 사용자

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> newList = new ArrayList<>();

        // Initialize newList
        for (String id : banned_id) {
            newList.add(new ArrayList<>());
        }

        // Populate newList with matching user_ids
        for (int index = 0; index < banned_id.length; index++) {
            String bannedId = banned_id[index];
            for (String userId : user_id) {
                boolean flag = true;
                if (bannedId.length() != userId.length()) {
                    flag = false;
                } else {
                    for (int i = 0; i < bannedId.length(); i++) {
                        if (bannedId.charAt(i) == '*') {
                            continue;
                        } else if (bannedId.charAt(i) != userId.charAt(i)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    newList.get(index).add(userId);
                }
            }
        }

        List<List<String>> pathList = new ArrayList<>();
        for (String element : newList.get(0)) {
            List<String> temp = new ArrayList<>();
            temp.add(element);
            pathList.add(temp);
        }

        Set<Set<String>> totalPath = new HashSet<>();

        // DFS with pruning
        while (!pathList.isEmpty()) {
            List<String> tempPath = pathList.remove(pathList.size() - 1);
            int currentIndex = tempPath.size() - 1;

            if (currentIndex == banned_id.length - 1) {
                totalPath.add(new HashSet<>(tempPath));
                continue;
            }

            for (String element : newList.get(currentIndex + 1)) {
                if (!tempPath.contains(element)) {
                    List<String> newPath = new ArrayList<>(tempPath);
                    newPath.add(element);
                    pathList.add(newPath);
                }
            }
        }

        return totalPath.size();
    }


}
