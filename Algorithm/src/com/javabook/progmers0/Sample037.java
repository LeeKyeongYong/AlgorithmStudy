package com.javabook.progmers0;

import java.util.Scanner;

public class Sample037 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Solution37 s=new Solution37();
		System.out.println("정수를 입력해주세요!! ");
		int n=sc.nextInt();
		System.out.println("제곱승을 입력해주세요!!");
		int t=sc.nextInt();
		int result=s.solution(n, t);
		System.out.println("세균증식 결과값: "+result+" 마리가 증식되었습니다.");
	}
}
class Solution37 {
    public int solution(int n, int t) {
        int answer = 0;
        int cnt=0;
        if(n>=1&&n<=10&&t>=1&&t<=15) {
	        while(cnt!=t) {
	        	n*=2;
	        	cnt++;
	        }
	        answer=n;
        }
        return answer;
    }
}