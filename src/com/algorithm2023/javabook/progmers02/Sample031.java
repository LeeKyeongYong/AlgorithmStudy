package com.algorithm2023.javabook.progmers02;

public class Sample031 { //7로 나누기
    public static void main(String[] args) {
        int[] arr = {7, 77, 14};
        Solution31 s = new Solution31();
        int result = s.solution(arr);
        System.out.println("7로 나누기 개수: " + result);
    }
}
class Solution31 {
    public int solution(int[] array) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            String num = Integer.toString(array[i]);
            String[] arrays = num.split("");

            for (int j = 0; j < arrays.length; j++) {
                if (arrays[j].equals("7")) {
                    answer++;
                }
            }
        }
        return answer;
    }
}