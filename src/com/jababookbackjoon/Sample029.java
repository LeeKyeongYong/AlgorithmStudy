package com.jababookbackjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Sample029 { //백준 16928 뱀과 사다리게임
	
	static List<List<Integer>> graph;
	
	static int[] visited;
	
	static int N,M;
	
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		input();
		sol();
	}

	private static void sol() {
		// TODO Auto-generated method stub
		
		bfs(1);
		
		//처음 시작값을 1로 가정했으니 결과값에 -1.
		System.out.println(visited[100]-1);
	}

	private static void bfs(int i) {
		// TODO Auto-generated method stub
		int u;
		visited[N]=1;
		//처음 1의 최소1번이라 가정하고 결과값에서 -1 해야함
		
		queue=new LinkedList<>();
		
		queue.add(i);
		
		while(!queue.isEmpty()) {
			
			u=queue.poll();
			
			if(u==100) break; 
			
			//이 부분을 빼줘야 안전 graph size 101
			if(!graph.get(u).isEmpty()) {
				
				if(visited[graph.get(u).get(0)]==0||visited[graph.get(u).get(0)]>visited[u]) {
					
					visited[graph.get(u).get(0)]=visited[u];
					//x번 칸에 도착하면, y번 칸으로 이동, 이동횟수 증가안됨
				}
				
			} else {
				
				for(int j=1; j<=6; j++) {
					
					if(u+j<=100&&(visited[u+j]==0||visited[u+j]>visited[u])) {
						
						visited[u+j]=visited[u]+1;
						
						queue.add(u+j);
						
					}
				}
			}
		}
		
	}

	private static void input() {
		// TODO Auto-generated method stub
		
		int x,y;
		
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		
		M=sc.nextInt();
		
		graph=new ArrayList<>(100);
		
		visited=new int[101];
		
		for(int i=0; i<100; i++) {
			
			graph.add(new ArrayList<>());
			
		}
				
		for(int i=0; i<N; i++) {
			
			x=sc.nextInt();
			
			y=sc.nextInt();
			
			graph.get(x).add(y);
			
		}
		
		for(int i=0; i<M; i++) {
			
			x=sc.nextInt();
			
			y=sc.nextInt();
			
			graph.get(x).add(y);
			
		}
	
		sc.close();
		
	}
}
/*
3  7
32 62
42 68
12 98
95 13
97 25
93 37
79 27
75 19
49 47
67 17
*/