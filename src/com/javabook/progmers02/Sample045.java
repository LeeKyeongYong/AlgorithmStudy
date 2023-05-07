package com.javabook.progmers02;

public class Sample045 { //ī�并ġ
	public static void main(String[] args) {
		String[] cards1= {"i", "drink", "water"};
		String[] cards2= {"want", "to"}; 
		String[] goal= {"i", "want", "to", "drink", "water"};
		
		Solution45 s=new Solution45();
		String result=s.solution(cards1, cards2, goal);
		System.out.println("ī�并ġ: "+result);
		
	}

}
class Solution45 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
    	String answer = "";
    	answer="Yes";
    	int cardIndex1=0;
    	int cardIndex1Max=cards1.length;
    	int cardIndex2=0;
    	int cardIndex2Max=cards2.length;
    	for(int i=0;i<goal.length; i++) {
    		String curStr=goal[i];
    		if(cardIndex1<cardIndex1Max&&curStr.equals(cards1[cardIndex1])) {
    			cardIndex1++;
    		} else if(cardIndex2<cardIndex2Max&&curStr.equals(cards2[cardIndex2])) {
    			cardIndex2++;
    		} else {
    			answer="No";
    		}
    	}
    	
    	return answer;
    }
}