package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample019 { //백준 1107 리모콘
	
	static int min_cnt=0x3f3f3f3f;
	static int num_int;
	static int[] btn_set= {1,1,1,1,1,1,1,1,1,1};
	
	public static void find(String num) {
		for(int i=0; i<10; i++) {
			if(btn_set[i]==1) {
				String tmp_num=num+Integer.toString(i);
				min_cnt=Math.min(min_cnt, Math.abs(num_int-Integer.parseInt(tmp_num))+tmp_num.length());
			
				if(tmp_num.length()<6) {
					find(tmp_num);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		num_int=sc.nextInt();
		int n=sc.nextInt();
		min_cnt=Math.min(min_cnt,Math.abs(100-num_int));
		
		for(int i=0; i<n; i++) {
			int k=sc.nextInt();
			btn_set[k]=0;
		}
		if(n<10) {
			find("");
		}
		System.out.println(min_cnt);
		sc.close();
	}
}
/*
입력>>
5457
3
6 7 8

*/