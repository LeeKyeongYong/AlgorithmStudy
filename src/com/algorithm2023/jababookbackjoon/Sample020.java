package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample020 { //백준1012 유기농배추
	
	static int n,m,cabbage;
	static boolean[][] a;
	static boolean[][]check;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static boolean dfs(int y,int x) {
		if(check[y][x]) return false;
		check[y][x]=true;
		for(int i=0; i<4; i++) {
			int next_x=x+dx[i]; //3.동,서,남,북으로 1칸씩 이동
			int next_y=y+dy[i];
			
			if(next_x>=0&&next_y>=0&&next_x<m&&next_y<n&&next_y<n&&a[next_y][next_x])
				//4. 인근지역에 배추가 있을경우, 해당 지역 방문처리
				dfs(next_y,next_x);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		int TC=sc.nextInt();
		for(int i=0; i<TC; i++) {
			int bug_count=0;
			m=sc.nextInt();
			n=sc.nextInt();
			cabbage=sc.nextInt();
			a=new boolean[n][m];
			check=new boolean[n][m];
			
			
			for(int j=0; j<cabbage; j++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				a[y][x]=true;//1.행 -y 축, 열-X축
			}
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(a[j][k]&&!check[j][k]) {
						//2.탐색안한 구역일 경우, dfs 수행&count
						if(dfs(j,k)) bug_count++;
					}
				}
			}
			
		
			System.out.println(bug_count);
		}
		System.out.println();
	}
}
/*
 입력 >>
  2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
 */
