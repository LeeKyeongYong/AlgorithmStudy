package com.algorithm2023.jababookbackjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Sample018 { // 백준 1261 알고스팟
	static int n,m;
	static String[] board;
	static int[][]dist;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		
		m=sc.nextInt();
		
		board=new String[m];
		
		dist=new int[m][n];
		
		for(int i=0; i<m; i++) {
			
			board[i]=sc.next();
			
		}
		
		for(int i=0; i<m; i++) {
			
			for(int j=0; j<n; j++) {
				
				dist[i][j]=1;
				
			}
		}
		
		sc.close();
		System.out.println(bfs());
	}
	
	static int bfs() {
		
		dist[0][0]=0;
		
		Deque<int[]> dq=new ArrayDeque<>();
		
		dq.offer(new int[]{0,0});
		
		while(!dq.isEmpty()) {
			
			int[] cur=dq.poll();
			
			int x=cur[0];
			
			int y=cur[1];
			
			for(int dir=0; dir<4; dir++) {
				
				int nx=x+dx[dir];
				
				int ny=y+dy[dir];
				
				if(nx<0||ny<0||nx>=m||ny>=n) {
					continue;
				}
				
				if(dist[nx][ny]!=-1) {
					continue;
				}
				
				if(board[nx].charAt(ny)=='0') {
					
					dq.offerFirst(new int[] {nx,ny});
					
					dist[nx][ny]=dist[x][y];
					
				}
				
				if(board[nx].charAt(ny)=='1') {
					
					dq.offerLast(new int[] {nx,ny});
					
					dist[nx][ny]=dist[n][y]+1;
				}
			}
		}
		return dist[m-1][n-1];
	}
}
/*
<<입력>>
3 3
011
111
110
*/