package com.algorithm2023.jababookbackjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Sample030 { //백준 18870 좌표압축

	
	public static int[]getDistincStoredArray(int[] arr){
		
		HashMap<Integer,Boolean> map=new HashMap<>();
		
		int index=0;
		
		for(int num:arr) {
			map.put(num, true);
		}
		
		int[]distinctArr=new int[map.size()];
		
		for(int num:map.keySet()) {
			
			distinctArr[index]=num;
			
			index++;
		}
		
		//정렬
		sort(distinctArr,0,distinctArr.length-1);
		
		return distinctArr;
		
	}
	
	private static void sort(int[] arr,int left,int right) {
		
		if(left>=right) {
			
			return;
		}
		
		int pivot=arr[(left+right)/2];
		
		int partition=partition(arr,left,right,pivot);
		
		sort(arr,left,partition-1);
		
		sort(arr,partition,right);
		
	}
	
	private static int partition(int[] arr,int left,int right,int pivot) {
		
		while(left<=right){
			
			while(arr[left]<pivot) {
				
				left++;
				
			}
			
			while(arr[right]>pivot) {
				
				right--;
				
			}
			
			if(left<=right) {
				
				swap(arr,left,right);
				
				left++;
				
				right--;
				
			}
			
		}
		
		return left;
		
	}
	
	private static void swap(int[] arr,int i,int j) {
		
		int temp=arr[i];
		
		arr[i]=arr[j];
		
		arr[j]=temp;
		
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		HashMap<Integer,Integer> dic = new HashMap<>();
		
		StringBuilder sb=new StringBuilder();
		
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int[] arr=new int[n];
		
		for(int i=0; i<n; i++) {
			
			arr[i]=Integer.parseInt(st.nextToken());
			
		}
		
		int[] arr2=getDistincStoredArray(arr);
		
		for(int i=0; i<arr2.length; i++) {
			
			dic.put(arr[i],i);
			
		}
		
		for(int i=0; i<n; i++) {
			sb.append(dic.get(arr[i])).append(' ');
		}
		
		System.out.println(sb);
		
		br.close();
	}
}



/*
 
 5
2 4 -10 4 -9
 
 */
