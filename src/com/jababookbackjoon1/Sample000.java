package com.jababookbackjoon1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sample000 {//백준 11400 단절선
	
	private static int V,E;
	private static List<Integer>[] Edge;
	private static int[] visited;
	private static List<Pair> answer;
	
	static class Pair implements Comparable<Pair>{
		int first;
		int second;
		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if(this.first==o.first) {
				return this.second - o.second;
			}
			
			return this.first-o.first;
		}
		
	}
	
	public static int DFS(int Parent,int start,int Order) {
		int res=Order;
		visited[start]=Order;
		
		for(int i=0; i<Edge[start].size(); i++) {
			int Next=Edge[start].get(i);
			if(Parent == Next) {
				continue;
			}
			
			if(visited[Next]==0) {
				int Next_Order=DFS(start,Next,Order+1);
				if(Next_Order > visited[start]) {
					answer.add(new Pair(Math.min(start, Next),Math.max(start,Next)));
				}
				res=Math.min(start, Next_Order);
			} else {
				res=Math.min(res, visited[Next]);
			}
		}
		return res;
		
	}
	
	public static void Input() {
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		Edge = new List[V+1];
		for(int i=1; i<=V; i++) {
			Edge[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			Edge[A].add(B);
			Edge[B].add(A);
		}
	}
	
	public static void Settings() {
		for(int i=1; i<=V; i++) {
			Collections.sort(Edge[i]);
		}
		visited=new int[V+1];
		answer=new ArrayList<>();
		for(int i=1; i<=V; i++) {
			if(visited[i]==0) {
				DFS(0,i,1);
			}
		}
	}
	
	public static void Find_Answer() {
		Collections.sort(answer);
		System.out.println(answer.size());
		for(Pair pair : answer) {
			int s=pair.first;
			int e=pair.second;
			System.out.println(s+ " "+e);
		}
	}
	
	public static void main(String[] args) {
		Input();
		Settings();
		Find_Answer();
	}
}
/*
입력>>
7 8
1 4
4 5
5 1
1 6
6 7
2 7
7 3
2 3

출력>>
2
1 6
6 7
*/