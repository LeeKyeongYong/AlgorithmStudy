package com.javabook.progmers02;

public class Sample018 { //��ġ�� ������ ����
	public static void main(String[] args) {
		Solution18 s=new Solution18();
		//int[][]lines= {{0,1},{2,5},{3,9}};
		//int[][]lines= {{-1,1},{1,3},{3,9}};
		int[][]lines= {{0,5},{3,9},{1,10}};
		int result=s.solution(lines);
		System.out.println("��ġ�� ������ ����: "+result);
	}
}
class Solution18 {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] lineArray=new int[200];

        for(int i=0; i<lines.length; i++) {
        	
        	for(int j=lines[i][0]+100; j<lines[i][1]+100; j++) {
        		lineArray[j]++;
        	}
        }
        for(int i=1; i<lineArray.length; i++) {//��ģ�κ� ����ϱ�
        	if(lineArray[i]>1) {
        		answer++;
        	}
        }
        return answer;
    }
}