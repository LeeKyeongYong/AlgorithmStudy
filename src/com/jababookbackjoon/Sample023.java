package com.jababookbackjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sample023 {//백준 1107 리모콘_다른버전2
	
	static int min_cnt=0x3f3f3f3f;
	static int num_int=0;
	static Set<Integer> btn_set=new HashSet<>();
	
	public static void search(String num) {
		for(int btn: btn_set) {
			String tmp_num=num+btn;
			min_cnt=Math.min(min_cnt,Math.abs(num_int-Integer.parseInt(tmp_num))+tmp_num.length());
			
			if(tmp_num.length()<6) {
				search(tmp_num);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		num_int=sc.nextInt();
		int n=sc.nextInt();
		min_cnt=Math.min(min_cnt,Math.abs(100-num_int));
		if(n>0) {
			for(int i=0; i<n; i++) {
				btn_set.add(sc.nextInt());
			}
		}
		
		if (n < 10) {search("");}
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