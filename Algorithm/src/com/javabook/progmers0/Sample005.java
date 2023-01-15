package com.javabook.progmers0;

public class Sample005 {
	public static void main(String[] args) {
		Solution5 s=new Solution5();
		int result=s.solution(4);
		System.out.println("resultÀÇ °ª:"+result);
	}
}

class Solution5 {
    public int solution(int n) {
        int answer = 0;
        for(int i=0; i<=n; i+=1) {
        	if(i%2==0)
        		answer+=i;
        }
        return answer;
    }
}


