package com.javabook.progmers02;

public class Sample028 {//���ڿ� �б�
	public static void main(String[] args) {
		String a="hello";
		String b="ohell";
		Solution28 s=new Solution28();
		int result=s.solution(a, b);
		System.out.println("���ڿ� �б� �����: "+result);
	}
}
class Solution28 {
    public int solution(String A, String B) {
        int answer = 0;
        
        String result=A;
        for(int i=0; i<A.length(); i++) {
        	if(result.equals(B)) {
        		return answer;
        	}else {
        		String change=result.substring(result.length()-1);
        		result=change+result.substring(0,result.length()-1);
        		answer++;
        	}
        }
        return -1;
    }
}