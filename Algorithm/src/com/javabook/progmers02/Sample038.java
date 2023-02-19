package com.javabook.progmers02;

public class Sample038 {//외계어 사전
	public static void main(String[] args) {
		String[] spell= {"p", "o", "s"};
		String[] dic= {"sod", "eocd", "qixm", "adio", "soo"};
		Solution38 s=new Solution38();
		int result = s.solution(spell, dic);
		System.out.println("외계어 사전: "+result);
	}
}
class Solution38 {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        answer=2;
        
        for(String dics: dic) {
        	boolean isRight=true;
        	for(String speels:spell) {
        		if(dics.indexOf(speels)==-1) {
        			isRight=false;
        		}
        	}
        	if(isRight) {
        		answer=1;
        		break;
        	}
        }
        return answer;
    }
}