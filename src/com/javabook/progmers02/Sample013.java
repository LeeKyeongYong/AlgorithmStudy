package com.javabook.progmers02;

import java.util.Arrays;

public class Sample013 { //369게임
	public static void main(String[] args) {
		Solution13 s=new Solution13();
		int order=3693;
		int solution=s.solution(order);
		System.out.println("369게임: "+solution);
	}
}


class Solution13 {
    public int solution(int order) {
        int answer = 0;
        String orderChnage=String.valueOf(order);
        answer=Long.valueOf(Arrays.stream(orderChnage.split("")).
        		filter(intVal->intVal.equals("3")||intVal.equals("6")||intVal.equals("9")).count()).intValue();
        return answer;
    }
}