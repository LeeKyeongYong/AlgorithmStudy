package com.javabook.progmers02;

public class Sample035 { //다항식 더하기
	public static void main(String[] args) {
		//String polynomial="3x + 7 + x";
		String polynomial="x + x + x";
		Solution35 s=new Solution35();
		String result=s.solution(polynomial);
		System.out.println("다항식 더하기: "+result);
	}
}
class Solution35 {
    public String solution(String polynomial) {
        String answer = "";
        int coefficient=0; //계수
        int constantnumber=0; //상수
        
        String coefficientStr="";//계수문자열
        String constantStr="";//상수문자열
        
       
        for(String s:polynomial.split(" ")) {
        	if(s.contains("x")) {
        		coefficient+=s.equals("x")? 1 : 
        			Integer.parseInt(s.substring(0,s.length()-1));
        	} else if(!s.contains("+")) {
        		constantnumber+=Integer.parseInt(s);
        	}
        }
        
        coefficientStr=coefficient > 0 ? coefficient == 1 ? "x" : coefficient+"x":"";
        constantStr=constantnumber > 0 ? String.valueOf(constantnumber):"";
        
        if(coefficient>0) {
        	if(constantnumber>0) {
        		answer+=coefficientStr+" + "+constantStr;
        	} else {
        		answer+=coefficientStr;
        	}
        } else if(constantnumber > 0) {
        	answer+=constantStr;
        }
        
        return answer;
    }
}