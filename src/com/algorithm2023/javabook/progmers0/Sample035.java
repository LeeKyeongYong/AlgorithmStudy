package com.algorithm2023.javabook.progmers0;

public class Sample035 {
	public static void main(String[] args) {
		//String[] s1={"a", "b", "c"};
		//String[] s2= {"com", "b", "d", "p", "c"};
		String[] s1={"n", "omg"};
		String[] s2= {"m", "dot"};
		
		Solution35 s=new Solution35();
		System.out.println("�迭�� ���絵�� "+s.solution(s1, s2));
	}
}
class Solution35 {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(int i=0; i<s1.length; i++) {
        	for(int j=0; j<s2.length; j++) {
        		if(s1[i].equals(s2[j])) {
        			answer++;
        		}
        	}
        }
        return answer;
    }
}