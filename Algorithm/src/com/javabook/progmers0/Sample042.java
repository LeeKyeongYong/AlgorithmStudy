package com.javabook.progmers0;

public class Sample042 { //모스부호1
	public static void main(String[] args) {
		Solution042 s=new Solution042();
		System.out.println("모스부호 출력: "+s.solution(".--. -.-- - .... --- -."));
	}
}
class Solution042 {
    public String solution(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.",
          	    "--.","....","..",".---","-.-",".-..",
          	    "--","-.","---",".--.","--.-",".-.",
          	    "...","-","..-","...-",".--","-..-",
          	    "-.--","--.."};
        String[] text=letter.split(" ");
        for (int i=0; i<text.length; i++) {
        	for(int j=0; j<morse.length; j++) {
	        		if(text[i].equals(morse[j])) {
	        			answer+=(char)(j+97);
	        		}
        	}
        }
        return answer;
    }
}