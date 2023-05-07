package com.javabook.progmers0;

public class Sample043 {//개미군단
	public static void main(String[] args) {
		Solution43 s=new Solution43();
		System.out.println("개미군단: "+s.solution(23));
	}
}
class Solution43 {
    public int solution(int hp) {
        int answer =0;
        answer+=(hp/5);
        hp%=5;
        answer+=(hp/3);
        hp%=3;
        answer+=(hp/1);
        return answer;
    }
}