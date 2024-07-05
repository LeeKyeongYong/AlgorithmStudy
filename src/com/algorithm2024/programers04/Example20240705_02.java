package com.algorithm2024.programers04;

import java.util.HashMap;
import java.util.Map;

public class Example20240705_02 { //월간 코드 챌린지 시즌1스타 수열

    public int solution(int[] a) {
        int answer = -1;

        // 현재 배열에 숫자들이 나온 횟수들
        Map<Integer, Integer> els = new HashMap<>();
        for (int num : a) {
            els.put(num, els.getOrDefault(num, 0) + 1);
        }

        // a에 있는 각 원소 k를 기준으로 스타 배열을 만들 수 있는지 검사
        for (int k : els.keySet()) {
            // 현재 k의 등장횟수가 스타 수열에 사용된 공통 인자 횟수 이하면 continue
            if (els.get(k) <= answer) {
                continue;
            }

            // k의 등장 횟수
            int cnt = 0;
            int idx = 0;
            while (idx < a.length - 1) {
                // 두 칸 모두 k가 포함 안되어있거나 두 칸이 같은 값이면 스타수열 안되니까 continue
                if ((a[idx] != k && a[idx + 1] != k) || (a[idx] == a[idx + 1])) {
                    idx++;
                    continue;
                }

                // 스타수열의 원소로 추가할 수 있는 경우 k 사용횟수 1 증가
                cnt++;
                // 다음 배열 탐색을 위해 두칸 점프
                idx += 2;
            }

            // 스타 수열 완성에 쓰인 공통 원소 k가 사용된 최대 횟수 갱신
            answer = Math.max(cnt, answer);
        }

        return answer == -1 ? 0 : answer * 2;
    }

}
