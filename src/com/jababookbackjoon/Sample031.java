package com.jababookbackjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sample031 { //백준 17219 비밀번호찾기 
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		int M=sc.nextInt();
		
		Map<String,String> m=new HashMap<>();
		
		String a,b;
		
		for(int i=0; i<N; i++) {
		
			a=sc.next();
			
			b=sc.next();
			
			m.put(a,b);
		
		}
		System.out.println();
		for(int i=0; i<M; i++) {
			
			a=sc.next();
			
			System.out.println(m.get(a));
			
		
		}
		System.out.println();
		sc.close();
	}
}
/*
입력>>
16 4
noj.am IU
acmicpc.net UAENA
startlink.io THEKINGOD
google.com ZEZE
nate.com VOICEMAIL
naver.com REDQUEEN
daum.net MODERNTIMES
utube.com BLACKOUT
zum.com LASTFANTASY
dreamwiz.com RAINDROP
hanyang.ac.kr SOMEDAY
dhlottery.co.kr BOO
duksoo.hs.kr HAVANA
hanyang-u.ms.kr OBLIVIATE
yd.es.kr LOVEATTACK
mcc.hanyang.ac.kr ADREAMER
startlink.io
acmicpc.net
noj.am
mcc.hanyang.ac.kr
*/