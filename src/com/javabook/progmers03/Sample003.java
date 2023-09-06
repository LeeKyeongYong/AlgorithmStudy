package com.javabook.progmers03;

public class Sample003 {
  public static void main(String[] args) {//프로그래머스 글자 이어 붙여 문자열 만들기
	  String my_string="cvsgiorszzzmrpaqpe"; //문자열 저장
	  int[]index_list= {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};//변수에 정수 저장
	  
	  Solution003 s=new Solution003(); //호출하기
	  String result = s.solution(my_string, index_list);//인자를 받는다
	  System.out.println("글자 이어 붙여 문자열 만들기: "+result); //결과값을 출력한다.
  }
}
class Solution003{
	public String solution(String my_string,int[] index_list) {
		StringBuilder answerBuilder = new StringBuilder();
		for(int x:index_list) { //반복문을 사용하여 각 인덱스에 문자열을 가져와
			answerBuilder.append(my_string.charAt(x)); //추가한다.
		}
		return answerBuilder.toString(); //인덱스처리가 끝나면 반환한다.
	}
}
