package com.algorithm2023.javabook.progmers0;

public class Sample041 {//���� ���� ��
	public static void main(String[] args) {
		//������ 2
    	//������ 0
    	//���� 5
		Solution41 s=new Solution41();
		System.out.println("���� ���� �� �����??: "+s.solution("205"));
	}
}
class Solution41 {
    public String solution(String rsp) {
    	
        String answer = "";
        for(int i=0; i<rsp.length(); i++) {
        	if(rsp.split("")[i].equals("0")) {
        		answer += "5";
        	} else if(rsp.split("")[i].equals("2")) {
        		answer += "0";
        	} else if(rsp.split("")[i].equals("5")) {
        		answer += "2";
        	} else {
        		answer += "";
        	}
        }
        return answer;
    }
}