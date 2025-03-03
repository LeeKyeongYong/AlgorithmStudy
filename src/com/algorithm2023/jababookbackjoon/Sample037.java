package com.algorithm2023.jababookbackjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sample037 { //백준 7662 이중 우선순위 큐
	
	static class Number implements Comparable<Number>{
		
		int value;
		int index;

		public Number(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Number o) {
			// TODO Auto-generated method stub
			if(this.value == o.value) {
				return Integer.compare(this.index,o.index);
			}
			return Integer.compare(this.value, o.value);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int n=Integer.parseInt(br.readLine());
			PriorityQueue<Number> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Number> minHeap = new PriorityQueue<>();
			
			boolean[] visited = new boolean[n];
			
			for(int i=0; i<n; i++) {
				String[] input = br.readLine().split(" ");
				String oper = input[0];
				int num = Integer.parseInt(input[1]);
				if(oper.equals("1")) {
					Number number = new Number(num,i);
					maxHeap.offer(number);
					minHeap.offer(number);
					visited[i]=true;
				} else {
					if(num == 1) {
						while(!maxHeap.isEmpty()&&!visited[maxHeap.peek().index]) {
							maxHeap.poll();
						}
						if(!maxHeap.isEmpty()) {
							visited[maxHeap.poll().index] = false;
						}
					} else {
						while(!minHeap.isEmpty()&&!visited[minHeap.peek().index]) {
							minHeap.poll();
						}
						if(!minHeap.isEmpty()) {
							visited[minHeap.poll().index]=false;
						}
					}
					
				}
			}
			while(!maxHeap.isEmpty()&&!visited[maxHeap.peek().index]) {
				maxHeap.poll();
			}
			while(!maxHeap.isEmpty()&&!visited[minHeap.peek().index]) {
				minHeap.poll();
			}
			if(maxHeap.isEmpty()||minHeap.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(maxHeap.peek().value+" "+minHeap.peek().value);
			}
		}
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

*/