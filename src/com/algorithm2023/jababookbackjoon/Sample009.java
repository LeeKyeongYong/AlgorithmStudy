package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample009 {//백준20125번 쿠키의 신체측정
	public static void main(String[] args) {
		//사용자로부터 입력을 받는다.
		Scanner sc=new Scanner(System.in);
		System.out.print("판의 크기를 입력하세요: ");
		int N=sc.nextInt();//판 크기
		
		System.out.println("");
		
		char[][] board=new char[N][N];
		boolean sign=false;
		int x=0,y=0;
		int left_arm=0;
		int right_arm=0;
		int back=0;
		int line2=0; //허리 끝
		int left_leg=0;
		int right_leg=0;
		
		
		
		//입력
		for(int i=0; i<N; i++) {//판의내용을 입력받는다.
			String line=sc.next();
			for(int j=0; j<N; j++) {//입력받은은 문자열 하나씩 쪼개서
				board[i][j]=line.charAt(j);//board라는 판에 하나씩 삽입한다.
			}
		}
		
		
		//머리를 통해 심장찾기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j]=='*') {//판배열을 읽으면서 '*' 문자를 찾는다.
					x=i+2;
					y=j+1;
					System.out.println(x+""+y);
					sign=true;
					break;
				}
			}
			if(sign) {
				break;
			}
		}
		
		//왼팔검사
		for(int i=0; i<y-1; i++) {
			if(board[x-1][i]=='*') {
				left_arm+=1;
			}
		}
		
		//오른팔 검사
		for(int i=y; i<N; i++) {
			if(board[x-1][i]=='*') {
				right_arm+=1;
			}
		}
		
		//허리검사
		for(int i=x; i<N; i++) {
			if(board[i][y-1]=='*') {
				back+=1;
				line2=i;
			}
		}
		
		//왼쪽 다리검사
		//밑에서 부터 허리 끝까지 *이 있으면 갯수 세기
		for(int i=N-1; i>line2; i--) {
			if(board[i][y-2]=='*') {//밑에서부터 허리 끝까지의 열(y-2)에 해당하는 위치에 있는 문자검사
				left_leg+=1;//왼쪽 1씩증가
			}
		}
		
		//오른쪽 다리검사
		//밑에서부터 허리끝까지 *이 있으면 갯수 세기
		for(int i=N-1; i>line2; i--) {
			if(board[i][y]=='*') { //위에내용과 동일하다...
				right_leg+=1;//오른쪽 1씩 증가
			}
		}
		//길이를 출력하는 코드
		System.out.println(left_arm+""+right_arm+""+back+""+left_leg+""+right_leg);
		sc.close();
	}
}
/*
입력할때

5
_____
__*__
_***_
__*__
_*_*_
*/