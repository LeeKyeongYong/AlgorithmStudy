package com.algorithm2023.javabook.progmers0;

import java.util.Scanner;

public class Sample033 {
	public static void main(String[] args) {
		Solution33 s=new Solution33();
		Scanner sc=new Scanner(System.in);
		System.out.println("���ڿ��� �Է����ּ���..");
		String my_string=sc.next();
		int[] solution=s.solution(my_string);
		System.out.println("���ڿ��� �ƴѰ���... ");
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
	}
}
class Solution33 {
    public int[] solution(String my_string) {
    	
        int[] answer = {};//���
        
        String fillter="";//�������͸��ϴ� ����
        
        String[] trn= {};//��ȯ��Ų��.
        
        char[] array=my_string.toCharArray(); //char�� ��ȯ
        
        for(int i=0; i<array.length; i++) {//��������
        	if(array[i]>=48&&array[i]<=57) { //���ڿ��ƴѰ���??
        		fillter+=array[i];
        	}
        }
        
        
        answer = new int[fillter.length()];
        trn=new String[fillter.length()];
        for(int i=0; i<fillter.length(); i++) {//�ߺ��� ���ڵ� ����..
        	trn[i]=fillter.charAt(i)+"";
        	answer[i]=Integer.parseInt(trn[i]);
        }
        
        //�������� �����ϱ�
        for(int i=0;i<answer.length-1;i++){
            
            for(int j=0; j<answer.length-1-i;j++){
                if(answer[j]>answer[j+1]){                   
                    int tmp = answer[j];
                    answer[j] = answer[j+1];
                    answer[j+1] = tmp;                  
                }              
            }          
        }
        
        return answer;
    }
}