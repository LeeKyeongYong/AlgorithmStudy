package com.algorithm2024.programers03;

import java.util.HashSet;

public class Example20240529_03 { //코딩테스트 연습문제 등대

    public static int solution(int n, int[][] lighthouse) {

        int answer = 0;
        int[] linkedCntArr;
        HashSet<Integer> edgeHs = new HashSet<>();
        HashSet<Integer> turnOnHs = new HashSet<>();
        int[][] remainingLightHouse;
        int remainingCnt;
        for (int a = 0; a < n; a++) {
            linkedCntArr = new int[n + 1];
            remainingLightHouse = new int[lighthouse.length][2];
            remainingCnt = 0;

            for (int i = 0; i < lighthouse.length; i++) {
                linkedCntArr[lighthouse[i][0]]++;
                linkedCntArr[lighthouse[i][1]]++;
            }

            for (int i = 0; i < linkedCntArr.length; i++) {

                if (linkedCntArr[i] == 1) {
                    edgeHs.add(i);
                }
            }

            for (int i = 0; i < lighthouse.length; i++) {

                if (edgeHs.contains(lighthouse[i][0]) || edgeHs.contains(lighthouse[i][1])) {

                    if (edgeHs.contains(lighthouse[i][0])) {
                        turnOnHs.add(lighthouse[i][1]);
                    } else {
                        turnOnHs.add(lighthouse[i][0]);
                    }
                }
            }

            for (int i = 0; i < lighthouse.length; i++) {

                if (!turnOnHs.contains(lighthouse[i][0]) && !turnOnHs.contains(lighthouse[i][1])) {
                    remainingLightHouse[remainingCnt] = lighthouse[i];
                    remainingCnt++;
                }
            }


            if (remainingCnt == 0) {
                break;
            }

            if (remainingCnt == 1) {
                answer += 1;
                break;
            }

            if (remainingCnt < lighthouse.length) {
                lighthouse = new int[remainingCnt][2];

                for (int i = 0; i < remainingCnt; i++) {
                    lighthouse[i] = remainingLightHouse[i];
                }
            }


        }

        answer += turnOnHs.size();

        return answer;
    }

}
