package com.algorithm2023.jababookbackjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sample001 { //Q6159_�ڽ�Ƭ��Ƽ
	public static void main(String[] args) {
		/* �Է��Ұ��
		 4 6
		 3
		 5
		 2
		 1 
		 */
		
		/* ����Ұ��
		 4
		 */

		
		 try {
			 InputStreamReader ir = new InputStreamReader(System.in);
			 BufferedReader br = new BufferedReader(ir);
	         StringBuilder sb = new StringBuilder();
	        
	        //���� �� �Է�
	        int N,S,cows[],cnt=0;
	        int end=0;
	       
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        //�о�鸰 ���ڿ��� �ϳ��ϳ�  �ɰ���.
	        //StringTokenizer Ŭ������ ���ڿ��� �츮�� ������ �����ڷ� ���ڿ��� �ɰ��ִ� Ŭ�����Դϴ�.
	        
	        N = Integer.parseInt(st.nextToken());
	        //�ɰ� ���ڸ� ��Ʈ N�� ����
	        
	        S = Integer.parseInt(st.nextToken());
	        //�ɰ� ���ڸ� ��Ʈ S�� ����
	        cows = new int[N]; //�ɰ� N��ŭ �迭�� �����Ѵ�.
	        
	        for(int i=0;i<N;i++) {
				cows[i] = Integer.parseInt(br.readLine()); //�Է��� 3,5,2�� �־��ش�
			}
	        
	        //�����ϱ�
	        for(int i=0;i<cows.length;i++){
	           for(int j=0; j<cows.length-1-i;j++){
	                if(cows[j]>cows[j+1]){                   
	                    int tmp = cows[j];
	                    cows[j] = cows[j+1];
	                    cows[j+1] = tmp;                  
	                }              
	            }
	        }

       
	        //ȿ������ �ڵ带 ���� �� ������
	        //�迭�� Ž���ϸ鼭 ���� s���� ������ ���� ã��
	          for(int start = 0;start<N-1;start++) {
		        	end = start+1;
		         	
		        	if(cows[start]>=S)//s���� ũ�� ����������
		        		break;
		        	
		        	while(end <N && cows[start]+cows[end]<=S) {
		        	//S���� �۸� ������Ų��.
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
