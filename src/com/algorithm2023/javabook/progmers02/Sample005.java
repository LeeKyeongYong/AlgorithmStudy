package com.algorithm2023.javabook.progmers02;

public class Sample005 {
	public static void main(String[] args) {
		int n=7;
		Solution05 s=new Solution05();
		int solution= s.solution(n);
		System.out.println("result: "+solution);
	}
}
class Solution05 {
    public int solution(int n) {
        int answer = 0;
        int count=0;
        for(int i=1; i<=n; i++) {
        	
        	for(int j=1; j<=i; j++) {
        		count+=(i%j==0)?1:0;
        	}
        	answer+=(count>=3)?1:0;
        }
        return answer;
    }
}