package com.jababookbackjoon1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sample014 {//백준 2198 통계학
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		int[] data =new int[n];
		int sum = 0;
		int cnt = 1;
		int cntMax = 0;
		
		List<Integer> modeData = new ArrayList<>();
		
		
		
		for(int i=0; i<n; i++) {
			
			data[i] = Integer.parseInt(sc.nextLine());
			
		}
		
		Arrays.sort(data);
		
		for(int i=0; i<n; i++) {
			
			sum+=data[i];
			
		}
		
		int mean = Math.round((float)sum/n);
		
		System.out.println(mean);
		
		int median = data[n/2];
		
		System.out.println(median);
		
		int last=data[0];
		
		for(int i=1; i<n; i++) {
			if(data[i]!=last) {
				if(cnt>cntMax) {
					modeData.clear();
					modeData.add(last);
					cntMax=cnt;
				} else if(cnt == cntMax && !modeData.contains(last)) {
					
					modeData.add(last);
					
				}
				cnt = 1;
				last = data[i];
			} else {
				cnt++;
			}
		}
		
		if(cnt > cntMax) {
			modeData.clear();
			modeData.add(last);
		} else if(cnt == cntMax && !modeData.contains(last)) {
			
			modeData.add(last);
			
		}
		
		if(modeData.size()== 1) {
			System.out.println(modeData.get(0));
		} else {
			System.out.println(modeData.get(1));
		}
		
		int range=Math.abs(data[n-1]-data[0]);//범위구하기
		System.out.println(range);
		sc.close();
	}
}
/*
입력>>
5
1
3
8
-2
2

출력>>
2
2
1
10

*/