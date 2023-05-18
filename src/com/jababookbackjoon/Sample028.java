package com.jababookbackjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sample028 {//백준 1389 케빈베이컨의 6단계법칙 BFS로 경로 길이 구하기
	static int n,m;
	static int[][]graph;
	static int[] pathLength;
	static int[] result;
	static boolean[] visited;
	static final int MAX=101;
	
	static void bfs(int start) {
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(start);
		visited[start]=true;
		
		while(!queue.isEmpty()) {
			int i=queue.poll();
			for(int j=1; j<=n; j++) {
				if(graph[i][j]==1&&!visited[j]) {
					visited[j]=true;
					queue.offer(j);
					pathLength[j]=pathLength[i]+1;
				}
			}
		}
	}
	
	static int getMinPerson() {
		int bacon=result[1];
		int person=1;
		
		for(int i=2; i<=n; i++) {
			
			if(bacon > result[i]) {
				bacon = result[i];
				person=i;
			}
		}
		
		return person;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph=new int[MAX][MAX];
		pathLength=new int[MAX];
		result = new int[MAX];
		visited=new boolean[MAX];
		
		for(int i=0; i<m; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			graph[x][y]=graph[y][x]=1;
		}
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(visited, false);
			Arrays.fill(pathLength,0);
			
			bfs(i);
			
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				result[i]+=pathLength[j];
			}
		}
		System.out.println(getMinPerson());
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
