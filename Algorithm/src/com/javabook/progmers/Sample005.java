package com.javabook.progmers;

public class Sample005 {
	public static void main(String[] args) {
		Solution5 s=new Solution5();
		int result=s.solution(10);
		System.out.println("resultÀÇ °ª:"+result);
	}
}

class Solution5 {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
        	if(i%2==0)
        		answer+=i;
        }
        return answer;
    }
}


