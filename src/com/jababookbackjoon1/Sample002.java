package com.jababookbackjoon1;

import java.util.Scanner;

public class Sample002 { //백준 1019 책페이지
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] ary=new int[10];
		
		for(int cur = n,expr=1; cur!=0; expr*=10) {
			//현재 숫자의 일의 자리 숫자를 구한다.
			int idx=cur%10;
			
			//현재 숫자를 십의 자리부터 계산하기 위해 다음 숫자를 구한다.
			int next=cur/10;
			
			//0번 인덱스에 값을 할당한다.
			ary[0]+=next*expr;
			
			//1부터 일의 자리 숫자까지 반복하여 값을 할당한다.
			for(int i=1; i<=idx; i++) {
				ary[i]+=(next+1)*expr;
			}
			
			//일의 자리 숫자에 대한 조건적 할당을 수행한다.
			ary[idx]-=expr-(n%expr)-1;
			
			//일의 자리 숫자 다음부터 9까지 반복하여 값을 할당한다.
			for(int i=idx+1; i<10; i++) {
				ary[i]+=next*expr;
			}
			
			//다음 숫자를 현재 숫자로 업데이트한다.
			cur=next;
			
		}
		//배열의 모든 요소를 출력한다.
		for(int i=0; i<10; i++) {
			System.out.print(ary[i]+" ");
		}
		
		sc.close();
	}

}
/*
입력 >>
11

출력 >>
1 4 1 1 1 1 1 1 1 1

*/