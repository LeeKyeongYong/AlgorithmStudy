package com.algorithm2024.programers04;
import java.util.Arrays;
public class Example20240701_04 { //2019 카카오 개발자 겨울 인턴십 징검다리 건너기
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = Arrays.stream(stones).max().getAsInt();

        while (start <= end) {
            int cnt = 0;  // 건너지 못하는 연속된 횟수
            int mid = (start + end) / 2;

            // stones 확인
            for (int s : stones) {
                if (s - mid <= 0) {
                    cnt++;
                    if (cnt >= k) {
                        break;
                    }
                } else {
                    cnt = 0;
                }
            }

            if (cnt >= k) {
                end = mid - 1;  // 돌 줄여보기
            } else {
                start = mid + 1;  // 돌 늘려보기
                answer = start;
            }
        }

        return answer;
    }
}
