package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample013 { //백준 2669 직사각형 네개의 합집합의 면적 구하기

	public static void main(String[] args) {
	   int n=101;//입력으로 들어올 좌표의 최대값 할당
	   Scanner sc=new Scanner(System.in);
	   boolean[][] map=new boolean[n][n];//직사각형의 정보를 담을 boolean변수선언
	   //직사각형에대한 정보를 true로 저장한다.
	   int A,B,C,D,result=0; //직사각형 및 결과값 변수 선언
	   for(int i=0; i<4; i++) {
		   A=sc.nextInt();
		   B=sc.nextInt();
		   C=sc.nextInt();
		   D=sc.nextInt();
		   for(int j=A; j<C; j++) {
			   for(int k=B; k<D; k++) {
				   map[j][k]=true;//직사각형들의 정보를 담은 배열을 선언한것을 영역에대한
				   //정보 true로 저장한다.
			   }
		   }
	   }
	   
	   //결과값 계산하는 변수선언
	   for(int t=0; t<n; t++) {
		   for(int l=0; l<n; l++) {
			   if(map[t][l]) {
				   result++;
			   }
		   }
	   }
	   System.out.println(result);//결과값 반환
	   sc.close();
	}
}
/*
입력>>
1 2 4 4
2 3 5 7
3 1 6 5
7 3 8 6
*/