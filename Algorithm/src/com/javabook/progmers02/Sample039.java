package com.javabook.progmers02;

public class Sample039 {//������ ����3
	public static void main(String[] args) {
		int n=15;
		Solution39 s=new Solution39();
		int result=s.solution(n);
		System.out.println("������ ����3 ���: "+result);
	}
}
class Solution39 {
    public int solution(int n) {
        int answer = 0;
        answer=n;
        int i=1;
        while(i<=answer) {
        	if((i%3==0)||String.valueOf(i).contains("3")) {
        		answer++;
        	}
        	i++;
        }
        
        return answer;
    }
}