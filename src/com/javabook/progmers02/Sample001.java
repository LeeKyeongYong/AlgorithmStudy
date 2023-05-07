package com.javabook.progmers02;

public class Sample001 {
	public static void main(String[] args) {
		int[]num_list = {1,2,3,4,5,6,7,8};
		int n=2;
		Solution001 s=new Solution001();
		int[][] solution= s.solution(num_list, n);
		for(int i=0; i<solution.length; i++) {
			for(int j=0; j<solution[i].length; j++) {
				System.out.print(solution[i][j]+" ");
			}
		}
		System.out.println();
	}
}
class Solution001 {
    public int[][] solution(int[] num_list, int n) {
    	
    	   int[][] answer = {};
           int length = num_list.length;
           answer = new int[length/n][n];
           for(int i=0; i<length; i++){  
               answer[i/n][i%n]=num_list[i];   
           }
           return answer;
    }
}