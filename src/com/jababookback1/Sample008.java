package com.jababookback1;

import java.util.Scanner;

public class Sample008 {//백준 2439 별 찍기 2
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=1; i<=N; i++) {
			for(int j=0; j<N-i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
/*
입력>>
5

출력>>
    *
   **
  ***
 ****
*****
*/