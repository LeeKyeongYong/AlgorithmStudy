package com.algorithm2025.backjoon2.day006;

import java.util.Scanner;
import java.util.Arrays;


public class Example20250307_Q11948 { //과목선택

    private static final int SCIENCE_SUBJECTS = 4; // 물리, 화학, 생물, 지구과학
    private static final int SOCIAL_SUBJECTS = 2;  // 역사, 지리

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 과학과목(4개)과 사회과목(2개) 점수 입력 및 처리
            int[] scienceScores = inputScores(sc, SCIENCE_SUBJECTS);
            int[] socialScores = inputScores(sc, SOCIAL_SUBJECTS);

            // 최대 점수 계산 및 출력
            int maxScore = calculateMaxScore(scienceScores, socialScores);
            System.out.println(maxScore);
        } finally {
            sc.close(); // 자원 해제
        }
    }

    private static int[] inputScores(Scanner sc, int count) {
        int[] scores = new int[count];
        for (int i = 0; i < count; i++) {
            scores[i] = sc.nextInt();
        }
        return scores;
    }

    private static int calculateMaxScore(int[] scienceScores, int[] socialScores) {
        // 과학 과목 점수 정렬
        Arrays.sort(scienceScores);

        // 사회 과목 중 최대 점수 구하기
        int maxSocialScore = Math.max(socialScores[0], socialScores[1]);

        // 과학 3과목 + 사회 1과목의 합계 계산
        // (정렬 후 뒤에서 3개 = 상위 3개 점수)
        int totalScore = 0;
        for (int i = 1; i < scienceScores.length; i++) {
            totalScore += scienceScores[i];
        }

        return totalScore + maxSocialScore;
    }
}