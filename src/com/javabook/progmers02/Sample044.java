package com.javabook.progmers02;

public class Sample044 {//Ä¡Å² ÄíÆù
	public static void main(String[] args) {
		int chicken=100;
		Solution44 s=new Solution44();
		int result=s.solution(chicken);
		System.out.println("Ä¡Å² ÄíÆù °á°ú: "+result);
	}
}
class Solution44 {
    public int solution(int chicken) {
        int answer = -1;
        answer=chicken/9;
        if(chicken>1&&chicken%9==0) {
        	answer--;
        }
        return answer;
    }
}