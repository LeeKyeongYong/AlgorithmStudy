package com.jababookback1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Sample003 { //11280 2-SAT-3 
	
	private static int N,M;
	private static List<Integer>[] go,back;
	private static int[] inDegree;
	private static boolean[] visited;
	private static Stack<Integer> s;
	private static List<List<Integer>> scc;
	
	private static int notX(int x) {
		if(x>N) return x-N;
		return x+N;
	}
	
	private static void dfs1(int x) {
		if(visited[x])return;
		visited[x]=true;
		for(int next:go[x]) {
			dfs1(next);
		}
		s.push(x);
	}
	
	private static void dfs2(int x,List<Integer> v) {
		if(visited[x]) return;
		visited[x]=true;
		for(int next:back[x]) {
			dfs2(next,v);
		}
		v.add(x);
	}
	
	private static void intialize() {
		for(int i=1; i<=N; i++) {
			visited[i]=visited[i+N]=false;
		}
	}
	
	private static void solve() {
		
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		go=new List[2*N+1];
		back=new List[2*N+1];
		
		for(int i=1; i<=2*N; i++) {
			go[i] = new ArrayList<>();
			back[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			if(x<0) x=Math.abs(x)+N;
			if(y<0) y=Math.abs(y)+N;
			
			//~x->y
			go[notX(x)].add(y);
			back[y].add(notX(x));
			
			//~y ->  X
			go[notX(y)].add(x);
			back[x].add(notX(y));
		}
		
		visited=new boolean[2*N+1];
		s=new Stack<>();
		
		for(int i=1; i<=N; i++) {
			if(!visited[i])dfs1(i);
			if(!visited[i+N])dfs1(i+N);
		}
		
		intialize();
		
		scc = new ArrayList<>();
		while(!s.empty()) {
			int x=s.pop();
			if(!visited[x]) {
				List<Integer> v=new ArrayList<>();
				dfs2(x,v);
				scc.add(v);
			}
		}
		
		intialize();
		
		for(List<Integer> component: scc) {
			for(int x:component) {
				if(x>N) {
					if(visited[x]||visited[x-N]) {
						System.out.println(0);
						return;
					}
				}else {
					if(visited[x]||visited[x+N]) {
						System.out.println(0);
						return;
					}
				}
				
				visited[x]=true;
			}
			for(int x:component) {
				visited[x]=false;
			}
		}
		
		System.out.println(1);
		
		sc.close();
	}
	
	public static void main(String[] args) {
		solve();
	}
}
/*
 입력>>
 3 4
-1 2
-2 3
1 3
3 2

출력 >>
1
 
 
 */
