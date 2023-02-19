package com.javabook.progmers02;

public class Sample040 {// 유한소수 판별하기
	public static void main(String[] args) {
		int a=12;
		int b=21;
		Solution40 s=new Solution40();
		int result=s.solution(a, b);
		System.out.println("유한소수 판별하기: "+result);
	}
}

class Solution40 {
    public int solution(int a, int b) {
        int answer = 0;
        
        for(;b%2==0;) {
        	b=b/2;
        }
        
        for(;b%5==0;) {
        	b=b/5;
        }
        
        if((a/(double)b)%1==0) {
        	answer=1;
        } else {
        	answer=2;
        }
        
        return answer;
    }
}