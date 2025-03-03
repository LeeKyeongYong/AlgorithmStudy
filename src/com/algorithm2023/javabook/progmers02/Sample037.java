package com.algorithm2023.javabook.progmers02;

public class Sample037 {//종이 조각 개수
    public static void main(String[] args) {
        int[] sides = {11, 7};
        Solution37 s = new Solution37();
        int result = s.solution(sides);
        System.out.println("종이 조각 개수: " + result);
    }
}
class Solution37 {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        int lowSize = 0;
        int heightSize = 0;
        for(int i = 0; i < sides.length; i++) {
            if(sides[i] > max) {
                max = sides[i];
            }
            if(sides[i] < min) {
                min = sides[i];
            }
        }
        
        lowSize = max - min;
        heightSize = max + min;
        answer = heightSize - lowSize - 1;
        return answer;
    }
}
