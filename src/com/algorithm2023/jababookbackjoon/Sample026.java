package com.algorithm2023.jababookbackjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Sample026 { //백준 1389 케빈베이컨의 6단계법칙 일반버전(오답)
	static boolean[] visited;
	static List<Integer>[] graph;
	
	
	static int getLength(int a,int b) {
		int cnt=0;
		
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(a);
		visited[a]=true;
		
		while(!queue.isEmpty()) {
			int node=queue.poll();
			if(node==b) {
				break;
			}
			
		    for(int neighbor : graph[node]) {
				if(!visited[neighbor]) {
					visited[neighbor]=true;
					queue.offer(neighbor);
					cnt++;
				}
			}
		}
		
		
		return cnt;
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		visited=new boolean[n+1];
		graph=new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		for(int i=1; i<=n; i++) {
			int sum=0;
			for(int j=1; j<=n; j++) {
				if(i==j) {
					continue;
				}
				visited=new boolean[n+1];
				sum+=getLength(i,j);
			}
			System.out.println(sum);
		}
		
		sc.close();
	}
}
/*
입력>>
5 5
1 3
1 4
4 5
4 3
3 2
*/