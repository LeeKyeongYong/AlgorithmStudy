package com.javabook.progmers02;

import java.util.ArrayList;
import java.util.List;

public class Sample011 {//모음제거
	public static void main(String[] args) {
		Solution11 s=new Solution11();
		String my_string="bus";
		String result=s.solution(my_string);
		System.out.println("모음제거 결과: "+result);
	}
}
class Solution11 {
    public String solution(String my_string) {
        String answer = "";
        List<String> list=new ArrayList<>();
        String[] my=my_string.split("");
        for(int i=0; i<my.length; i++) {
        	if(my[i].equals("a")||my[i].equals("e")||my[i].equals("i")||my[i].equals("o")||my[i].equals("u")) {
        		list.add("");
        	} else {
        		list.add(my[i]);
        	}
        }
        for(String s:list) {
        	answer+=s;
        }
        return answer;
    }
}