package com.algorithm2023.jababookbackjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sample012 { //백준 3048번 개미
	 public static void main(String[] args){
		 //입력을 받는다.
	     Scanner sc=new Scanner(System.in);
	     int n1=sc.nextInt();
	     int n2=sc.nextInt();
	     String[] ant1=sc.next().split("");
	     String[] ant2=sc.next().split("");
	     int time=sc.nextInt();//시간입력
	     
	     //개미의 순서 정리
	     Collections.reverse(Arrays.asList(ant1));//더하는 방향을 맞춰준다.
	     List<String> antSum=new ArrayList<>(Arrays.asList(ant1));
	     antSum.addAll(Arrays.asList(ant2));//개미순서 합치기.
	     
	     //개미의 이동처리
	     for(int i=0; i<time; i++) {//TIME시간
	    	 List<Integer> temp=new ArrayList<>();
	    	 for(int j=1; j<antSum.size(); j++) {
	    		 if(Arrays.asList(ant2).contains(antSum.get(j))) {
	    			 if(Arrays.asList(ant1).contains(antSum.get(j-1))) {
	    				 temp.add(j);
	    				 //그룹1에 있는 개미이면 점프해 위치가 바뀌어야 하므로,
	    				 //temp배열에 인덱스값 저장
	    			 }
	    		 }
	    	 }
	    	 for(int q:temp) {
	    		 Collections.swap(antSum, q, q-1);//바향이 다른 두 개미의 위치바꿔주기
	    	 }
	     }
	     
	     //결과출력
	     String result=String.join("",antSum);//리스트인 결과를 문자열로 출력하기위한과정
	     System.out.println(result);
	}
}
/*
입력>>
3 3
ABC
DEF
0
*/