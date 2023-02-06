package com.javabook.progmers02;

public class Sample007 { //Á¦°ö½Â ¹®Á¦
	public static void main(String[] args) {
		Solution007 s=new Solution007();
		int n=144;
		int solution=s.solution(n);
		System.out.println("Á¦°ö¼ö ÆÇº°ÇÏ±â: "+solution);
	}
}
class Solution007 {
    public int solution(int n) {
        int answer = 0;
        answer=2;
        for(int i=1; i<=1000; i++) {
        	if(Math.pow(i,2)==n) {
        		answer=1;
        	}
        }
        return answer;
    }
}