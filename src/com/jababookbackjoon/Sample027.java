package com.jababookbackjoon;

import java.util.Scanner;

public class Sample027 { //백준 1389 케빈베이컨의 6단계법칙 플로이드-워셜 알고리즘

	static final int INF =(int)1e9;
	static final int MAX =101;
	static int n,m;
	static int[][] graph;
	
	public static void floyd() {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(i==j)
						continue;
					
					// i에서 k로, k에서 j로 가는 경로가있는데.
					else if(graph[i][k]!=0&&graph[k][j]!=0) {
						//i에서 j로 직접 가는 경로가 없으면
						if(graph[i][j]==0) {
							//k를 거쳐간다.
							graph[i][j]=graph[i][k]+graph[k][j];
						} else {
							//직접 가는 경로가 있으면
							//거쳐 가는 경로와 길이가 비교하여 최솟값으로 저장
							graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		graph=new int[MAX][MAX];
		
		for(int i=0; i<m; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			graph[x][y]=graph[y][x]=1;
		}
		
		floyd();
		int result = INF;//최소 베이컨 수
		int person = 0; //최소 케빈 베이컨 수를 갖는 사람의 번호
		
		for(int i=1; i<=n; i++) {
			//i에서 j로 가는 최소 경로 길이를 더한다.
			int sum=0;
			for(int j=1; j<=n; j++) {
				sum+=graph[i][j];
			}
			
			//최소 베이컨 수와 그 수를 갖는 사람 번호 갱신
			if(result > sum) {
				result=sum;
				person=i;
			}
		}
		
		System.out.println(person);
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