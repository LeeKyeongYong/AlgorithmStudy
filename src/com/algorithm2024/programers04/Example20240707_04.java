package com.algorithm2024.programers04;

public class Example20240707_04 { //Summer/Winter Coding(~2018) 기지국 설치

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int spreadSize = w * 2 + 1;

        // 시작 지점
        int start = 1;

        // Iterate over each station
        for (int station : stations) {
            // 설치된 기지국의 맨 뒤의 전파 범위
            int end = station - w - 1;

            if (start <= end) { // 설치된 기지국의 맨 뒤의 전파 범위보다 시작 지점이 뒤에 있을 경우 기지국 추가 설치
                int len = end - start + 1;
                answer += (len + spreadSize - 1) / spreadSize; // Calculate number of additional stations needed
            }

            // 설치된 기지국의 맨 앞의 전파 범위
            start = station + w + 1;
        }

        // 마지막 기지국의 전파 범위가 마지막 아파트까지 전파가 닿는지 확인
        if (start <= n) {
            int len = n - start + 1;
            answer += (len + spreadSize - 1) / spreadSize; // Calculate number of additional stations needed
        }

        return answer;
    }


}
