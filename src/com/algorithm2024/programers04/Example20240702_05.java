package com.algorithm2024.programers04;

public class Example20240702_05 { //월간 코드 챌린지 시즌3
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = Long.MAX_VALUE; // 초기 값을 가능한 최대 값으로 설정
        long start = 0;
        long end = 4 * (long)Math.pow(10, 14); // 주어진 범위의 최대값

        while (start <= end) {
            long mid = (start + end) / 2; // 주어진 시간
            long gold = 0; // 주어진 시간 내에 옮길 수 있는 금의 양
            long silver = 0; // 주어진 시간 내에 옮길 수 있는 은의 양
            long add = 0; // 주어진 시간 내에 옮길 수 있는 (금+은)의 양

            for (int i = 0; i < t.length; i++) {
                long nowG = g[i];
                long nowS = s[i];
                long nowW = w[i];
                long nowT = t[i];

                long moveCount = mid / (nowT * 2); // 운반 횟수 = 주어진 시간을 왕복 걸리는 시간으로 나눔
                if (mid % (nowT * 2) >= nowT) { // 나머지가 편도 걸리는 시간보다 크면 편도로 한 번 더 갈 수 있음
                    moveCount += 1;
                }

                gold += Math.min(nowG, moveCount * nowW); // 현재 도시의 금량과 최대로 옮길 수 있는 광물의 양을 비교해 작은 쪽을 더해줌
                silver += Math.min(nowS, moveCount * nowW);
                add += Math.min(nowG + nowS, moveCount * nowW);
            }

            if (gold >= a && silver >= b && add >= (a + b)) { // 조건을 모두 만족하면 시간을 줄여서 최소값을 찾음
                answer = Math.min(mid, answer);
                end = mid - 1;
            } else { // 그렇지 않으면 시간을 늘림
                start = mid + 1;
            }
        }

        return answer;
    }
}
