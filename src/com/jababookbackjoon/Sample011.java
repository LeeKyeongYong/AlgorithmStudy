package com.jababookbackjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sample011 { //백준 1941 소문난 칠공주
	static int ans,cnt;
	static int[] dx= {-1,0,1,0};
	static int[]dy= {0,-1,0,1};
	static char[][] array;
	static boolean[][] map;
	static boolean[] visited;
	static Scanner sc=new Scanner(System.in);
	//static int n=sc.nextInt();
	static int n=5;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		
		//System.out.println("입력할 글수와 라인수 입력: ");
		
		array=new char[n][n];
		
		for(int i=0; i<n; i++) {
			array[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<(n*n); i++) {
			visited=new boolean[(n*n)];
			map=new boolean[n][n];
			dfs(i,1,0);
			//sc.close();
		}
		System.out.println(ans);
	}
	public static void dfs(int k,int cnt,int s) {
		if(array[k/n][k%n]=='S') {
			++s;
		}
		visited[k]=true;
		map[k/n][k%n]=true;
		
		if((n+2)==cnt) {
			if(s>=(n-1)) {
				find();
			}
		} else {
			for(int i=k+1; i<(n*n); i++) {
				if(!visited[i]) {
					dfs(i,cnt+1,s);
				}
			}
			
			
		}
		visited[k]=false;
		map[k/n][k%n]=false;
	}
	
	public static void find() {
		for(int i=0; i<(n*n); i++) {
			if(visited[i]) {
				int y=i/n;
				int x=i%n;
				
				boolean[][]visited=new boolean[n][n];
				visited[y][x]=true;
				cnt=1;
				isComponent(y,x,visited);
				return;
			}
		}
	}
	
	public static void isComponent(int y,int x,boolean[][]checked) {
		if((n+2)==cnt) {
			++ans;
		} else {
			for(int i=0; i<(n-1); i++) {
				int ny=dy[i]+y;
				int nx=dx[i]+x;
				if(0<=ny&&ny<n&&0<=nx&&nx<n) {
					if(map[ny][nx]&&!checked[ny][nx]) {
						checked[ny][nx]=true;
						++cnt;
						isComponent(ny, nx, checked);
					}
				}
			}
		}
	}
}
/*
입력>>
YYYYY
SYSYS
YYYYY
YSYYS
YYYYY
*/