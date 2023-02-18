package com.jababookbackjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sample001 { //Q6159_�ڽ�Ƭ��Ƽ
	public static void main(String[] args) {
		 try {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        //���� �� �Է�
	        int N,S,cows[],cnt=0;
	        int end=0;
	       
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        S = Integer.parseInt(st.nextToken());
	        cows = new int[N];
	        
	        for(int i=0;i<N;i++)
				
					cows[i] = Integer.parseInt(br.readLine());
			
	        //�����ϱ�
	        for(int i=0;i<cows.length-1;i++){
	            
	            for(int j=0; j<cows.length-1-i;j++){
	                if(cows[j]>cows[j+1]){                   
	                    int tmp = cows[j];
	                    cows[j] = cows[j+1];
	                    cows[j+1] = tmp;                  
	                }              
	            }          
	        }
	        
	        
		        for(int start = 0;start<N-1;start++) {
		        	end = start+1;
		        	if(cows[start]>=S)
		        		break;
		        	while(end <N && cows[start]+cows[end]<=S) {
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
