package com.jababookbackjoon1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Sample015 { //백준 1966번 프린터 큐
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int testN = sc.nextInt();
		
		for(int i=0; i<testN; i++) {
			
			int count=0;
			
			int n=sc.nextInt();
			
			int m=sc.nextInt();
			
			PriorityQueue<Integer> pq =new PriorityQueue<>((a,b) -> b-a);//내림차순 정렬
			
			Queue<int[]> q = new LinkedList<>();
			
			for(int j=0; j<n; j++) {
				
				int importance = sc.nextInt();
				
				q.offer(new int[] {j,importance});
				
				pq.offer(importance);
			}
			
			while(!q.isEmpty()) {
				
				int[] front = q.poll();
				
				int location =front[0];
				
				int value = front[1];
				
				if(pq.peek()==value) {
					
					pq.poll();
					
					count++;
					
					if(m==location) {
						
						System.out.println(count);
						break;
					}
				} else {
					q.offer(front);
				}
			}
		}
		
		
		sc.close();
	}
}
/*
입력>>

3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1


출력>>

1
2
5

*/