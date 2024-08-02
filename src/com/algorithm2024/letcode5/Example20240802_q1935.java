package com.algorithm2024.letcode5;

public class Example20240802_q1935 {//LIS 문제이나 그리디로 해결 가능한 문제 (어려웠음)

    public int numTeams(int[] rating) {
        int answer = 0;

        for (int boundary = 0; boundary < rating.length; boundary++) {
            int leftSamller = 0;
            int leftLager = 0;
            int rightSmaller = 0;
            int rightLager = 0;

            for (int left = 0; left < boundary; left++) {
                if (rating[left] < rating[boundary]) {
                    leftSamller++;
                } else {
                    leftLager++;
                }
            }

            for (int right = boundary + 1; right < rating.length; right++) {
                if (rating[boundary] > rating[right]) {
                    rightSmaller++;
                } else {
                    rightLager++;
                }
            }

            // 오름차순 기준 팀 수 : 기준수보다 작은 수 * 기준수보다 큰 수 (팀의 수는 3이므로)
            answer += (leftSamller * rightLager) + (leftLager * rightSmaller);
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240802_q1935 sol = new Example20240802_q1935();

        // 3
        System.out.println(sol.numTeams(new int[]{2, 5, 3, 4, 1}));

        // 0
        System.out.println(sol.numTeams(new int[]{2, 1, 3}));
    }

}
