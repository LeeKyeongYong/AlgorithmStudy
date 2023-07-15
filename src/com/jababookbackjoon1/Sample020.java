package com.jababookbackjoon1;

import java.util.Scanner;

public class Sample020 { //백준 10872 팩토리얼
	public static int fact(int n) {
		if(n>1) { //넘어온 n이 1보다 클경우
			return n*fact(n-1); //입력한 n곱하기 n-1 fact함수를 호출한다.
		} else {
			return 1; //n이 1일경우 1을 반환한다.
		}
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in); //Scanner클래스 생성
		int N=sc.nextInt(); //정수를 입력받음
		sc.close(); //scanner객체 종료
		System.out.println(fact(N)); //재귀함수 호출한다음 입력받은 정수 N을 계산처리
	}
}
/*
문제>>
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력>>
첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
10

출력>>
첫째 줄에 N!을 출력한다.
3628800

설명>>
해당 소스코드는 입력으로 양의 정수 N을 받아 N을 계산하고 출력하는 간단한 팩토리얼 계산기이다.
입력 5를 주면 5x4x3x2x1=120을 출력한다.
*/