package com.javabook.progmers02;

import java.util.Arrays;

public class Sample009 {
	public static void main(String[] args) {
		Solution09 s=new Solution09();
		String str="aAb1B2cC34oOp";
		int solution=s.solution(str);
		System.out.println("¼û¾îÀÖ´Â ¼ıÀÚÀÇ µ¡¼À (1): "+solution);
	}
}
class Solution09 {
    public int solution(String my_string) {
        int answer = 0;
        int[] array=Arrays.stream(my_string.replaceAll("[A-Z|a-z]","").split("")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<array.length; i++) {
        	answer+=array[i];
        }
        return answer;
    }
}