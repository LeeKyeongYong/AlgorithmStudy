package com.javabook.progmers03;

//나머지가 1이 되는 수 찾기 프로그래머스
public class Solution010 {
	public static void main(String[] args) {
		Solution011 s=new Solution011();
		int n=s.solution(10);
		System.out.println("나머지가 1이되는 수 찾기 답: "+n);
	}
}

class Solution011{
	public int solution(int n) {
		int i=2; //나머지가 1이 되는 수를 찾기위한 시작값 2로 초기화한다.
		while(i<n) { //i가 n보다 작은 동안 반복한다.
			if(n%i==1) { //n을 i로 나눈 나머지가 1인경우
				return i; //i를 반환하고 종료한다.
			}
			i++; //i를 증가시켜 다음값을  확인한다.
		}

		return -1; // 나머지가 1이 되는 수를 찾지 못한 경우 -1을 반환한다.
	}
}
