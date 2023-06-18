package com.jababookback1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Sample013 { //백준 2164 카드2
	
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=1; i<=n; i++) {
			
			deque.add(i);
			
		}
		
		while(deque.size() > 1) {
			
			deque.poll();
			
			int num=deque.poll();
			
			deque.add(num);
		}
		
		System.out.println(deque.peek());
		
		sc.close();
		
	}
	
}
/*
입력>
2
1
3
2
3

출력>

4

*/