package com.javabook.progmers02;

public class Sample034 {//이진수 더하기
	public static void main(String[] args) {
		String bin1="10";
		String bin2="11";
		Solution34 s=new Solution34();
		String result=s.solution(bin1, bin2);
		System.out.println("이진수 더하기 결과값: "+result);
	}
}
class Solution34 {//2진수 더하기
    public String solution(String bin1, String bin2) {
        String answer = "";
        int numBin1=Integer.parseInt(bin1,2);
        int numBin2=Integer.parseInt(bin2,2);
        answer=Integer.toBinaryString(numBin1+numBin2);
        return answer;
    }
}