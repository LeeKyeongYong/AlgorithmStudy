package com.algorithm2023.jababookbackjoon;

import java.io.*;
public class Sample004 { //Q2018_��������5
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start=0,end=0;//�������� ����
		int sum=0,cnt=0;//sum: ��,cnt: ������(����)
		
		while(start<=N) { //end����
			while(++end<=N) { //�κ��� ����
				sum+=end;
				if(sum>=N) {
					if(sum==N) cnt++;
					break;
				}
			}
			while(++start<=N) {
				sum-=start;
				if(sum<=N) {
					if(sum<=N) cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
