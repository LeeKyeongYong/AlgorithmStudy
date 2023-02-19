package com.javabook.progmers02;

import java.util.*;

public class Sample042 {//등수 매기기
	public static void main(String[] args) {
		int[][] score= {{80, 70},{90, 50},{40, 70},{50, 80}};
		Solution42 s =new Solution42();
		int[] result=s.solution(score);
		for(int i=0; i<result.length; i++) {
			System.out.println("등수 매기기 결과값: "+result[i]);
		}
	}
}
class Solution42 {
    public int[] solution(int[][] score) {
        int[] answer = {};
        answer=new int[score.length];
        List<Integer> scoreList=new ArrayList<>();
        for(int[] i:score) {
        	scoreList.add(i[0]+i[1]);
        }
        
        scoreList.sort(Comparator.reverseOrder());
        
        for(int i=0; i<score.length; i++) {
        	answer[i]=scoreList.indexOf(score[i][0]+score[i][1])+1;
        }
        
        return answer;
    }
}