package com.javabook.progmers0;

public class Sample040 {//순서쌍의 개수
	public static void main(String[] args) {
		Solution40 s=new Solution40();
		System.out.println(s.solution(20));
	}
}
class Solution40 {
    public int solution(int n) {
        int answer = 0;
        int i=1;
        while(i<=n) {
        	if(n%i==0) {
        		answer++;
        	}
        	i++;
        }
        return answer;
    }
}