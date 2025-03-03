package com.algorithm2023.javabook.progmers03;

public class Sample005 {
	public static void main(String[] args) {//프로그래머스 문자열 바꿔서 찾기
		String myString="ABBAA";
		String pat ="AABB";
		int result = new Solution005().solution(myString, pat);//설정된 문자열 입력한다.
		System.out.println("문자열 바꿔서 찾기: "+result);//결과를 출력한다.
	}
}
class Solution005{
	public int solution(String myString,String pat) {
		int answer = 0;//변수 초기화 시킨다
		String str = "";//문자열 생성한다. A,B바꿔가면서 사용한다.
		for(int i=0; i<myString.length(); i++) {//문자열 하나씩 검사한다.
			if("A".equals(myString.substring(i,i+1))) {//A란 문구열이있으면
				str+="B"; //B로 변경
			} else { //아니면 A로 변경
				str+="A";
			}
		}
		if(str.contains(pat)) {//포함하는지 확인하는 여부
			answer = 1; //포함하면 1을 반환
		}else {
			answer = 0; //그렇지 않으면 0을 반환
		}
		return answer;
	}
}