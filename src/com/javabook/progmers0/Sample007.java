package com.javabook.progmers0;

import java.util.Arrays;

public class Sample007 {
	public static void main(String[] args) {
		Solution7 s=new Solution7();
		int numbers[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.println("배열의 평균값: "+s.solution(numbers));
	}
}
class Solution7 {
    public double solution(int[] numbers) {
        double answer = 0;
        int sum=0;
        for(int i=0; i<numbers.length; i++) {
        	if(numbers[i]>=0&&numbers[i]<=100) {
        	  sum += numbers[i];
        	  answer=sum/(double)numbers.length;
        	}
        }
        //return answer;
        return Arrays.stream(numbers).average().orElse(0);//Stream으로도 출력이된다.
    }

}