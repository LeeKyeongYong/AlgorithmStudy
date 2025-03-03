package com.algorithm2023.jababookbackjoon1;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sample009 {//백준 7662 이중 우선순위 큐
	
	static int test_case,N;
	
	static int[] check;
	
	static Scanner sc=new Scanner(System.in);
	
	static class Pair implements Comparable<Pair>{

		int num;
		
		int index;
		
		public Pair(int num,int index) {
			this.num=num;
			this.index=index;
		}
		
		
		public int getNum() {
			return num;
		}



		public void setNum(int num) {
			this.num = num;
		}



		public int getIndex() {
			return index;
		}



		public void setIndex(int index) {
			this.index = index;
		}



		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num,o.num);
		}
	
		
	}
	
	public static void solve() {
		
		N=sc.nextInt();
		
		PriorityQueue<Pair> q_high = new PriorityQueue<>(Collections.reverseOrder());
		
		PriorityQueue<Pair> q_low = new PriorityQueue<>();
		
		check = new int[1000001];
		
		for(int i=0; i<N; i++) {
			char order = sc.next().charAt(0);
			int num=sc.nextInt();
			if(order =='I') {
				q_high.offer(new Pair(num,i));
				q_low.offer(new Pair(num,i));
				check[i]=1;
			} else if(order=='D') {
				if(num==-1) {
					while(!q_low.isEmpty()) {
						Pair pair = q_low.peek();
						int X=pair!=null? pair.getIndex():-1;
						if(check[X]==1)
							break;
						q_low.poll();
					}
					if(!q_low.isEmpty()) {
						Pair pair = q_low.peek();
						int X=pair!=null ? pair.getIndex():-1;
						check[X]=0;
					}
				} else {
					while(!q_high.isEmpty()) {
						Pair pair = q_low.peek();
						int x=pair!=null? pair.getIndex():-1;
						if(check[x]==1)
							break;
						q_high.poll();
					}
					if(!q_high.isEmpty()) {
						Pair pair = q_low.peek();
						int x=pair!=null? pair.getIndex():-1;
						check[x]=0;
					}
				}
			}
		}
		while(!q_low.isEmpty()) {
			Pair pair = q_low.peek();
			int x=pair!=null ? pair.getIndex():-1;
			if(check[x]==1)
				break;
			q_low.poll();
		}
		while(!q_high.isEmpty()) {
			Pair pair = q_low.peek();
			int x=pair!=null ? pair.getIndex():-1;
			if(check[x]==1)
				break;
			q_high.poll();
		}
		if(q_high.isEmpty()&&q_low.isEmpty())
			System.out.println("EMPTY");
		else
			System.out.println(q_high.peek().getNum()+" "+q_low.peek().getNum());
		
	}
	
	public static void main(String[] args) {
		test_case=sc.nextInt();
		for(int i=0; i<test_case; i++) {
			solve();
		}
		sc.close();
	}
}

/*
 입력>>
 2
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1
9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333
 
 
 출력>>
 EMPTY
333 -45
 
 */
