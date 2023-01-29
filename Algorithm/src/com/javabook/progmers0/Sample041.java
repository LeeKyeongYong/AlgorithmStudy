package com.javabook.progmers0;

public class Sample041 {//가위 바위 보
	public static void main(String[] args) {
		//가위는 2
    	//바위는 0
    	//보는 5
		Solution41 s=new Solution41();
		System.out.println("가위 바위 보 결과는??: "+s.solution("205"));
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