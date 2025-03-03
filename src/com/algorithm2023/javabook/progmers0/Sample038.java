package com.algorithm2023.javabook.progmers0;

public class Sample038 { //�ܰ��༺�� ����
	public static void main(String[] args) {
		Solution38 s=new Solution38();
		System.out.println("�ܰ� �༺���� "+s.solution(28));
	}
}

class Solution38 {
    public String solution(int age) {
        String answer = "";
        String returnStr=String.valueOf(age);
        String[] strArr=returnStr.split("");
        for(int i=0; i<strArr.length; i++) {
        	answer+=((char)(Integer.parseInt(strArr[i])+97));
        }
        return answer;
    }
}