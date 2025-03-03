package com.algorithm2023.javabook.progmers0;

class Solution2 {
    public int solution(int num1, int num2) {
        int answer = 0;
        /*
        if(num1==num2) {
        	answer=1;
        } else {
        	answer=-1;
        }
        */
        answer = (num1==num2)?1:-1;
        return answer;
    }
}
public class Sample002 {
	public static void main(String[] args) {
		
		Solution2 s=new Solution2();
		System.out.println("result: "+s.solution(2, 3));
		System.out.println("result: "+s.solution(11,11));
		System.out.println("result: "+s.solution(7,99));
	}
}

