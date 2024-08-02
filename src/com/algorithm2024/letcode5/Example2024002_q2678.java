package com.algorithm2024.letcode5;

public class Example2024002_q2678 {

    public int countSeniors(String[] details) {
        // 11 ~ 13
        int answer = 0;
        for(String s : details) {
            if(Integer.parseInt(s.substring(11, 13)) > 60) {
                answer++;
            }
        }

        return answer;
    }

}
