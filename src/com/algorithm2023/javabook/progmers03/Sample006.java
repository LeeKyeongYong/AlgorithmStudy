package com.algorithm2023.javabook.progmers03;

public class Sample006 {
	public static void main(String[] args) {
		String[] strArr= {"AAA","BBB","CCC","DDD"};
		Solution006 s=new Solution006();
		String[] result= s.solution(strArr);
		System.out.print("배열에서 문자열 대소문자 변환하기: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
}
class Solution006{
	public String[] solution(String[] strArr) { //입력을받는다.
		String[] answer = new String[strArr.length]; //입력을 받은 배열의 길이만큼 답변 배열을의 길이를 설정한다
		for(int i=0; i<strArr.length; i++) { //입력받은배열의 길이만큼 반복으로 도는데
			if(i%2==0) { // 짝수 배열은 소문자로 변경하고
				answer[i]=strArr[i].toLowerCase();
			}else { //홀수 배열칸은 대문자로 변경한다.
				answer[i]=strArr[i].toUpperCase();
			}
		}
		return answer; //변경된것은 출력한다.
	}
}