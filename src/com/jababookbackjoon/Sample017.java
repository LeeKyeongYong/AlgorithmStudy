package com.jababookbackjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Sample017 {//백준 1713 후보추천하기
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int W=sc.nextInt();
		int[] num=new int[W];
		for(int i=0; i<W; i++) {
			num[i]=sc.nextInt();
		}
		Map<Integer,int[]> photo=new HashMap<>();
		for(int i=0; i<W; i++) {
			if(photo.containsKey(num[i])) {
				int[] value=photo.get(num[i]);
				value[0]++;
			} else {
				if(photo.size()<N) {
					photo.put(num[i],new int[] {1,i});
				} else {
					List<Map.Entry<Integer,int[]>> list =new ArrayList<>(photo.entrySet());
					Collections.sort(list,new Comparator<Map.Entry<Integer,int[]>>(){

						@Override
						public int compare(Entry<Integer, int[]> o1, Entry<Integer, int[]> o2) {
							// TODO Auto-generated method stub
							if(o1.getValue()[0]!=o2.getValue()[0]) {
								return o1.getValue()[0]-o2.getValue()[0];
							}
							return o1.getValue()[1]-o2.getValue()[1];
						}
						
					});
					
					int del_key=list.get(0).getKey();
					photo.remove(del_key);
					photo.put(num[i],new int[] {1,i});
				}
			}
		}
		
		List<Integer> ans_list=new ArrayList<>(photo.keySet());
		Collections.sort(ans_list);
		StringBuilder sb=new StringBuilder();
		sb.append(ans_list.get(0));
		for(int i=1; i<ans_list.size(); i++) {
			sb.append(" ").append(ans_list.get(i));
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
/*
입력>>
3
9
2 1 4 3 5 6 2 7 2
*/