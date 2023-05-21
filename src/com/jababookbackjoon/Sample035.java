package com.jababookbackjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sample035 {//백준 1005 ACM Craft
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int N,K,W;
			
			int[] time=new int[1000];
			
			int[] pre=new int[1000];
			
			ArrayList<Integer>[] suc=new ArrayList[1000];
			
			N=sc.nextInt();
			
			K=sc.nextInt();
			
			for(int i=0; i<N; i++) {
				
				time[i]=sc.nextInt();
				
			}
			
			for(int i=0; i<K; i++) {
				
				time[i]=sc.nextInt();
				
			}
			
			for(int i=0; i<K; i++) {
				
				int X,Y;
				
				X=sc.nextInt();
				
				Y=sc.nextInt();
				
				if(suc[X-1] == null) {
					
					suc[X-1] = new ArrayList<>();
					
				}
				
				suc[X-1].add(Y-1);
				
				pre[Y-1]++;
				
			}
			
			W = sc.nextInt();
			
			W--;
			
			int[] result=new int[1000];
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				
				if(pre[i]==0) {
					
					queue.add(i);
					
				}
					
			}
			
			while(pre[W]>0) {
			
				int u=queue.poll();
				
				if(suc[u]!=null) {
					
					for(int next : suc[u]) {
						
						result[next] = Math.max(result[next],result[u]+time[u]);
						
						if(--pre[next] == 0) {
							
							queue.add(next);
							
						}
					}
				}
				
			}
			
			System.out.println(result[W]+time[W]);
			
		}
		
		sc.close();
	}
}
/*
입력>>
2
4 4
10 1 100 10
1 2
1 3
2 4
3 4
4
8 8
10 20 1 5 8 7 1 43
1 2
1 3
2 4
2 5
3 6
5 7
6 7
7 8
7
*/