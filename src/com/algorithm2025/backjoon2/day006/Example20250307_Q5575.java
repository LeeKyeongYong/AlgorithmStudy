package com.algorithm2025.backjoon2.day006;

import java.util.Scanner;

public class Example20250307_Q5575 { // 타임카드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 3명의 직원 데이터를 처리
        for (int i = 0; i < 3; i++) {
            // 출근 시간 (시, 분, 초)
            int startHour = sc.nextInt();
            int startMin = sc.nextInt();
            int startSec = sc.nextInt();

            // 퇴근 시간 (시, 분, 초)
            int endHour = sc.nextInt();
            int endMin = sc.nextInt();
            int endSec = sc.nextInt();

            // 근무 시간 계산을 초 단위로 통합하여 수행
            int startTimeInSeconds = startHour * 3600 + startMin * 60 + startSec;
            int endTimeInSeconds = endHour * 3600 + endMin * 60 + endSec;
            int workTimeInSeconds = endTimeInSeconds - startTimeInSeconds;

            // 결과 시, 분, 초로 변환
            int workHours = workTimeInSeconds / 3600;
            int workMinutes = (workTimeInSeconds % 3600) / 60;
            int workSeconds = workTimeInSeconds % 60;

            System.out.println(workHours + " " + workMinutes + " " + workSeconds);
        }

        sc.close(); // 자원 해제
    }
}