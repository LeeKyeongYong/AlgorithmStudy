package com.jababookback1;

import java.util.Scanner;

public class Sample016 { //백준 11021 A+B - 7
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in); //Scanner 생성
		int T=sc.nextInt(); //사용자로부터 테스트 케이스 갯수를 입력받음
		for(int i=1; i<=T; i++) { //반복문의 조건인 입력한 테스트 케이스만큼 순차적으로 처리
			int a=sc.nextInt(); //첫번째 케이스 할당받음
			int b=sc.nextInt(); // 두번째 케이스 할당받음
			
			System.out.println("Case #"+i+" : "+(a+b)); //a와 b가 합산하면서 출력함
		}
		sc.close(); //입력이 끝나면 Scanner 클래스 종료함.
	}
}

/*
 문제 >>
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 
 
 입력>>
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

5
1 1
2 3
3 4
9 8
5 2
 
 
 출력 >>
  각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
  Case #1: 2
Case #2: 5
Case #3: 7
Case #4: 17
Case #5: 7


 */
