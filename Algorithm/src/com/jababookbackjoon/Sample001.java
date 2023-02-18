package com.jababookbackjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sample001 { //Q6159_코스튬파티
	public static void main(String[] args) {
		 try {
			 InputStreamReader ir = new InputStreamReader(System.in);
			 BufferedReader br = new BufferedReader(ir);
	         StringBuilder sb = new StringBuilder();
	        
	        //선언 및 입력
	        int N,S,cows[],cnt=0;
	        int end=0;
	       
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        //읽어들린 문자열을 하나하나  쪼갠다.
	        //StringTokenizer 클래스는 문자열을 우리가 지정한 구분자로 문자열을 쪼개주는 클래스입니다.
	        
	        N = Integer.parseInt(st.nextToken());
	        //쪼갠 문자를 인트 N에 선언
	        
	        S = Integer.parseInt(st.nextToken());
	        //쪼갠 문자를 인트 S에 선언
	        cows = new int[N]; //쪼갠 N만큼 배열을 생성한다.
	        
	        for(int i=0;i<N;i++) {
				cows[i] = Integer.parseInt(br.readLine()); //입력한 3,5,2만 넣어준다
			}
	        
	        //정렬하기
	        for(int i=0;i<cows.length-1;i++){
	           for(int j=0; j<cows.length-1-i;j++){
	                if(cows[j]>cows[j+1]){                   
	                    int tmp = cows[j];
	                    cows[j] = cows[j+1];
	                    cows[j+1] = tmp;                  
	                }              
	            }
	        }
	        
	        //효율적인 코드를 위해 투 포인터
	        //배열을 탐색하면서 합이 s보다 작은것 갯수 찾기
	          for(int start = 0;start<N-1;start++) {
		        	end = start+1;
		        	if(cows[start]>=S)//s보다 크면 빠져나오고
		        		break;
		        	while(end <N && cows[start]+cows[end]<=S) {
		        	//S보다 작면 증가시킨다.
		        		cnt++;
		        		end++;
		        	}
		        } 
	          System.out.println(cnt);
	       
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	      
	}
}
