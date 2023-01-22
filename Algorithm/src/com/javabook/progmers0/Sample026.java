package com.javabook.progmers0;

import java.util.Scanner;

public class Sample026 {
	public static void main(String[] args) {
		Solution26 s=new Solution26();
		//int array[]= {149,180,192,170};
		int array[]= {180,120,140};
		Scanner sc=new Scanner(System.in);
		System.out.print("머쓱이의 키를 말해보세요..: ");
		int height=sc.nextInt();
		int result=s.solution(array, height);
		System.out.println("머슥이는 교실에서 "+result+" 번째 키가 큽니다.");
	}
}
class Solution26 {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int i=0; i<array.length; i++) {
        	if(array[i]>height) {
        		answer++;
        	}
        }
        return answer;
    }
}