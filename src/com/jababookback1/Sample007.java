package com.jababookback1;

import java.util.Scanner;

public class Sample007 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1; i<=n; ++i) {
			for(int j=1; j<=n-i+1; ++j) {
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
*****
****
***
**
*

*/