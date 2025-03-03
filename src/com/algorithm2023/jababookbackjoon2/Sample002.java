package com.algorithm2023.jababookbackjoon2;

import java.util.Scanner;

public class Sample002 { //백준 10569 다면체
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //입력한 수만큼 테스트 케이스 
		
		for(int i=0; i<n; i++) { //n번만큼 처리한다.
			int v = sc.nextInt(); //간선의 갯수를 받는다
			int e = sc.nextInt(); //간선의 곗수를 받는다
			
			int c = 2-v+e; //정점과 간선의 개수를 이용하여 그래프에 속하는 세 번째 종류의 객체의 개수 c를 계산
			System.out.println(c); //출력
		}
		
		sc.close();
	}
}
/*
문제>>
수학자가 구를 깎아서 볼록다면체를 만들었다. 
이 수학자는 임의의 볼록다면체에 대해 (꼭짓점의 수) - (모서리의 수) + (면의 수) = 2가 성립한다는 것을 알고 있다.
그래서 구를 깎는 게 취미인 이 사람은 꼭짓점, 모서리와 면의 수를 기록할 때 꼭짓점과 모서리의 수만 세고 면의 수는 세지 않는다.

입력>>
첫 번째 줄에 1 이상 100 이하의 자연수 T가 주어진다.
다음 T개의 줄에 4 이상 100 이하의 자연수 V와 E가 공백을 사이에 두고 주어진다. 
V와 E는 각각 꼭짓점의 개수와 모서리의 개수이다.

2
8 12
4 6

출력>>
6
4

*/