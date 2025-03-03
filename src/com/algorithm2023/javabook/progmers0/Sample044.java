package com.algorithm2023.javabook.progmers0;

public class Sample044 { // �ڸ��� ���ϱ�
	public static void main(String[] args) {
		Solution44 s=new Solution44();
		int result=s.solution(930211);
		System.out.println("�ڸ��� ����: "+result);
	}
}
class Solution44 {
    public int solution(int n) {
        int answer = 0;
        String[] result=Integer.toString(n).split("");
        for(int i=0; i<result.length; i++) {
        	answer+=Integer.parseInt(result[i]);
        }
        return answer;
    }
}