package com.algorithm2023.javabook.progmers03;

public class Sample004 {
	public static void main(String[] args) {
		int start_num=10; //숫자 10을 저장
		int end_num=3; //숫자 3을 저장
		Solution004 s=new Solution004();
		int[] result = s.solution(start_num, end_num);
		System.out.println("카운트 다운: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+", ");
		}
		
	}
}
class Solution004{
	public int[] solution(int start,int end) {
		int size =start-end +1; //배열 길이 설정
		int[] answer = new int[size];//결과 배열 셋팅
		for(int i=0; i<size; i++) { //size만큼
			answer[i] = start--; //배열 스타트값 감소하면서 저장
		}
		return answer;
	}
}