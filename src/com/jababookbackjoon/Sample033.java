package com.jababookbackjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sample033 { // 백준 1017번 소수 쌍
	
	static final int MAXN=2001;
	
	static boolean[] is_prime;
	
	static int arr_size;
	
	static List<Integer> a_set,b_set;
	
	static int[] a_match,b_match;
	
	static boolean[] visited;
	
	static List<List<Integer>> adj;
	
	static boolean DFS(int a_idx) {
		
		if(a_idx==0||visited[a_idx])
			return false;
		
		visited[a_idx]=true;
		
		for(int i=0; i<adj.get(a_idx).size(); ++i) {
			
			int b_idx=adj.get(a_idx).get(i);
			
			if(b_match[b_idx] == -1 || DFS(b_match[b_idx])) {
				
				a_match[a_idx] = b_idx;
				
				b_match[a_idx] = a_idx;
				
				return true;
			}
		}
		
		return false;
	}
	
	static void SireveErators() {
		is_prime = new boolean[MAXN + 1];
		Arrays.fill(is_prime, true);
		int sqrtn=(int)Math.sqrt(MAXN);
		
		is_prime[0]=is_prime[1]=false;
		for(int i=2; i<=sqrtn; ++i) {
			if(is_prime[i]) {
				for(int j=i*i; j<=MAXN; j+=i)
					is_prime[j]=false;
			}
		}
	}
	
	public static void main(String[] args) {

		List<Integer> answers = new ArrayList<>();
		
		Scanner sc=new Scanner(System.in);
		
		arr_size=sc.nextInt();
		
		int first_num=sc.nextInt();
		
		boolean is_first_even = first_num%2==0;
		
		a_set = new ArrayList<>();
		
		b_set = new ArrayList<>();
		
		a_set.add(first_num);
		
		for(int i=1; i<arr_size; ++i) {
			
			int temp=sc.nextInt();
			
			if(is_first_even) {
				
				if(temp%2==0)
					a_set.add(temp);
				else
					b_set.add(temp);
			} else {
				
				if(temp%2!=0)
					a_set.add(temp);
				else
					b_set.add(temp);
			}
		}
		
		if(b_set.size()!=a_set.size()) {
			
			System.out.println(-1);
			
			return;
			
		}
		
		SireveErators();
		
		adj=new ArrayList<>();
		
		for(int i=0; i<a_set.size(); ++i)
			adj.add(new ArrayList<>());
		
		for(int i=0; i<a_set.size(); ++i) {
		
			for(int j=0; j<b_set.size(); ++j) {
				
				if(is_prime[a_set.get(i)+b_set.get(i)])
					adj.get(i).add(j);
			}
		
		}
		
		for(int i=0; i<adj.get(0).size(); ++i) {
			
			int pair_b_idx=adj.get(0).get(i);
			
			int paired_size = 1;
			
			a_match = new int[a_set.size()];
			
			b_match = new int[b_set.size()];
			
			Arrays.fill(a_match,-1);
			
			Arrays.fill(b_match,-1);
			
			a_match[0] = pair_b_idx;
			
			b_match[pair_b_idx] = 0;
			
			for(int j=1; j<a_set.size(); ++j) {
				
				visited =new boolean[a_set.size()];
				
				if(DFS(j))
					paired_size++;
			}
			if(paired_size == b_set.size())
				answers.add(b_set.get(pair_b_idx));
		}
		
		if(!answers.isEmpty()) {
			
			answers.sort(null);
			
			for(int i=0; i < answers.size(); ++i)
				System.out.println(answers.get(i)+" ");
			
		} else {
			
			System.out.print(-1);
		
		}
		
		System.out.println();
		
		sc.close();
		
	}
}
/*
입력>>
6
1 4 7 10 11 12
*/