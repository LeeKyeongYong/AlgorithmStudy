package com.jababookbackjoon;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Sample021 {//백준 1003 피보나치 함수
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int T,N;
	     int[] F = {
	             1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
	             89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
	             10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
	             1346269, 2178309, 3524578, 5702887, 9227465,
	             14930352, 24157817, 39088169, 63245986, 102334155
	         };
		T=sc.nextInt();
		for(int i=0; i<T; i++) {
			N=sc.nextInt();
			System.out.println(F[N]+" "+F[N+1]);
			System.out.println();
		}
		System.out.println();
		sc.close();
	}
}
/*
입력>>
3
0
1
3
*/