package com.algorithm2023.javabook.progmers02;

public class Sample004 {
	public static void main(String[] args) {
		Solution004 s=new Solution004();
		int[] box= {10,8,6};
		int n=3;
		int solution=s.solution(box, n);
		System.out.println("result: "+solution);
	}
}
class Solution004 {
    public int solution(int[] box, int n) {
        int answer = 0;
        answer = (box[0]/n)*(box[1]/n)*(box[2]/n);
        return answer;
    }
}