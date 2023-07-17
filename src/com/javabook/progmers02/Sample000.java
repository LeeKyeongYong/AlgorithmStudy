package com.javabook.progmers02;

public class Sample000 {
    public static void main(String[] args) {
        // 01. 성적 처리를 위한 기본 점수 2개와 부가 점수 5개를 입력받는다.
        // Scanner sc = new Scanner(System.in);
        System.out.println("성적을 입력해주세요. 성적은 총 5개입니다.");
        int num = 5;
        // int num = sc.nextInt();
        int[] score = new int[num];

        int sum = 0;
        int totalSum = 0;

        score[0] = 30;
        score[1] = 50;
        score[2] = 80;
        score[3] = 85;
        score[4] = 88;

        // for(int i=0; i<score.length; i++) {
        //     score[i] = sc.nextInt();
        // }

        for (int j = 0; j < score.length; j++) {
            totalSum += score[j];
            if (score[j] > 80) {
                sum += score[j];
            }
        }
        // sc.close();
        System.out.println(num + " 명 중 80 이상의 점수 합: " + sum);
        System.out.println(num + " 명의 총 점: " + totalSum);
    }
}
