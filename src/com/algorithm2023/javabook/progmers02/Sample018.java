package com.algorithm2023.javabook.progmers02;

public class Sample018 { // 구간에 겹치는 선분 개수
    public static void main(String[] args) {
        Solution18 s = new Solution18();
        //int[][] lines = {{0,1},{2,5},{3,9}};
        //int[][] lines = {{-1,1},{1,3},{3,9}};
        int[][] lines = {{0,5},{3,9},{1,10}};
        int result = s.solution(lines);
        System.out.println("구간에 겹치는 선분 개수: " + result);
    }
}

class Solution18 {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] lineArray = new int[200];

        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0] + 100; j < lines[i][1] + 100; j++) {
                lineArray[j]++;
            }
        }
        for (int i = 1; i < lineArray.length; i++) { // 구간에 겹치는 선분 개수 세기
            if (lineArray[i] > 1) {
                answer++;
            }
        }
        return answer;
    }
}
