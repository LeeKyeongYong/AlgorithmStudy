package com.javabook.progmers02;

public class Sample015 {//������ϱ�
	public static void main(String[] args) {
		int n=24;
		Solution15 s=new Solution15();
		int[] solution=s.solution(n);
		for(int i=0; i<solution.length; i++) {
			System.out.print(solution[i]+" ");
		}
	}
}
class Solution15 {
    public int[] solution(int n) {
        int[] answer = {};
        int count=0;
        int[] array= new int[n];
        
        for(int i=1; i<=n; i++) {
        	if(n%i==0) { //����θ�ŭ ī��Ʈ ó��
        		array[count]=i;
        		count++;
        	}
        }
        answer = new int[count]; //����� �ۼ��ϱ����� �迭 ���� �����Ѵ�.
        for(int i=0; i<count; i++) {
        	if(array[i]!=0) { //����θ�ŭ ī��Ʈ ó��
        		answer[i]=array[i];
        	}
        }
        
        return answer;
    }
}