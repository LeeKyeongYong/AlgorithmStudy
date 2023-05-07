package com.javabook.progmers02;

public class Sample022 {//다음에 올 숫자
	public static void main(String[] args) {
		int[] common= {2,4,8};
		//int[] common= {1,2,3,4};
		Solution22 s=new Solution22();
		int result=s.solution(common);
		System.out.println("다음에 올 숫자: "+result);
	}
}
class Solution22 {
    public int solution(int[] common) {
        int answer = 0;
        if((common[1]-common[0])==(common[2]-common[1])) {
        	answer =common[common.length-1]+(common[1]-common[0]);
        } else {
        	answer =common[common.length-1]*(common[1]/common[0]);
        }
        return answer;
    }
}