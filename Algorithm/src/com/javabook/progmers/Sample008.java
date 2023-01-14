package com.javabook.progmers;

public class Sample008 {
	public static void main(String[] args) {
		Solution8 s8=new Solution8();
		String[] babbling= {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		System.out.println("조카의 옹알이 길이: "+s8.solution(babbling));
	}
}

class Solution8 {
    public int solution(String[] babbling) {
        int answer = 0;
        //조카는 아직 "aya", "ye", "woo", "ma"

        if(babbling.length>=1&&babbling.length<=100) {
        	for(int i=0; i<babbling.length; i++) {
	           if(babbling[i].length()>=1&&babbling[i].length()<=15) {
	        	babbling[i]=babbling[i].replaceFirst("aya","1");
	        	babbling[i]=babbling[i].replaceFirst("ye","1");
	        	babbling[i]=babbling[i].replaceFirst("woo","1");
	        	babbling[i]=babbling[i].replaceFirst("ma","1");
	        	babbling[i]=babbling[i].replace("1","");
	        	if(babbling[i].isEmpty()) {
	        		answer+=1;
	        	}
            }
         }
      }
        return answer;
    }
}