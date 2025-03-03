package com.algorithm2023.jababookbackjoon;

import java.util.Scanner;

public class Sample007 { //백준 2195 문자열복사
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String s=sc.nextLine(); //문자열받는다
		String p=sc.nextLine(); //문자열 입력받는다.
		int idx=0; //idx 초기화
		int answer=0; //정답 0으로 초기화
		
		while(idx<p.length()) { //while문 돌면서 idx가 p문자열의 길이보다 작을때까지 돈다.
			char start=p.charAt(idx);//start변수에 p문자열에서 idx문자를 저장한다.
			int tmp=0; //초기화
			int cnt=0; //0으로 초기화
			while(true) { 
				int temp_idx=idx; //idx로 초기화한다
				int temp=0; //0으로 초기화한다
				int ix=s.indexOf(start,tmp); //s문자열에 start문자,tmp문자를 찾는다.
				if(ix==-1) { //만약 찾지못할경우 빠져 나온다.
					break;
				}
				while(ix<s.length()&&temp_idx<p.length()) {//ix,tmp_idx,p문자열의 비교하면서 일치하는지
					if(s.charAt(ix)==p.charAt(temp_idx)) {//일치한다면 1씩증가한다.
						ix++;
						temp_idx++;
						temp++;
					} else {//일치하지않는다면 빠져나간다.
						break;
					}
				}
				tmp=ix+1; //ix+에 일씩 증가시켜 tmp변수에 삽입한다.
				cnt=Math.max(cnt, temp); //일치한문자열의 길이 중 더 긴값을 cnt에 저장한다.
			}
			answer++; //answer출력하는값에 1씩증가한다.
			idx+=cnt; //idx값을 cnt를 더해 갱신한다.
		}
		System.out.println(answer);
	}
}
/*
입력>>
xy0z
zzz0yyy0xxx
*/