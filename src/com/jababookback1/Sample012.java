package com.jababookback1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample012 { //백준 2775 부녀회장이 될테야
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int count=Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
				
				int K = Integer.parseInt(br.readLine());
				
				int N = Integer.parseInt(br.readLine());
				
				
				sb.append(PopleNumber(K,N)).append("\n");
		}
		
		System.out.println(sb);//결과출력
		
		br.close();
		
	}
	
	//인원수 계산하는 메서드
	static int PopleNumber(int k,int n) {
			if(n==0)
				return 0;
			else if(k==0)
				return n;
			else return PopleNumber(k,n-1)+PopleNumber(k-1,n);
	}
	
}
/*

입력>>

2
1
3
2
3

출력>>

6
10
*/