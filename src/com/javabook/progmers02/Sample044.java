package com.javabook.progmers02;

public class Sample044 { //치킨 배달
    public static void main(String[] args) {
        int chicken = 100;
        Solution44 s = new Solution44();
        int result = s.solution(chicken);
        System.out.println("치킨 배달 개수: " + result);
    }
}

class Solution44 {
    public int solution(int chicken) {
        int answer = -1;
        answer = chicken / 9;
        if (chicken > 1 && chicken % 9 == 0) {
            answer--;
        }
        return answer;
    }
}
