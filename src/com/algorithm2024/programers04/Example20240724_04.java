package com.algorithm2024.programers04;

import java.util.HashMap;
import java.util.Map;

public class Example20240724_04 { //2024 KAKAO WINTER INTERNSHIP 가장 많이 받은 선물

    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giftRecords = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> nextMonthGifts = new HashMap<>();

        // 초기화
        for (String friend : friends) {
            giftRecords.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
            nextMonthGifts.put(friend, 0);
        }

        // 선물 기록 업데이트
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            giftRecords.get(giver).put(receiver, giftRecords.get(giver).getOrDefault(receiver, 0) + 1);
            giftScore.put(giver, giftScore.get(giver) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);
        }

        // 다음 달 선물 수 계산
        for (String giver : friends) {
            for (String receiver : friends) {
                if (!giver.equals(receiver)) {
                    int giftsFromGiver = giftRecords.get(giver).getOrDefault(receiver, 0);
                    int giftsFromReceiver = giftRecords.get(receiver).getOrDefault(giver, 0);

                    if (giftsFromGiver > giftsFromReceiver) {
                        nextMonthGifts.put(giver, nextMonthGifts.get(giver) + 1);
                    } else if (giftsFromGiver == giftsFromReceiver && giftScore.get(giver) > giftScore.get(receiver)) {
                        nextMonthGifts.put(giver, nextMonthGifts.get(giver) + 1);
                    }
                }
            }
        }

        // 최대값 반환
        return nextMonthGifts.values().stream().mapToInt(v -> v).max().orElse(0);
    }

}
