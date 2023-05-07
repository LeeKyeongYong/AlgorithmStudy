package com.javabook.study;

import java.util.Arrays;
import java.util.List;

public class Sample001 {
	public static void main(String[] args) {
		System.out.println("자바 테스트입니다.");
		List<Integer> number=Arrays.asList(1,2,1,3,3,2,4);
		number.stream().filter(i -> i%2!=0)
		.distinct()
		.forEach(System.out::println);
	}
}
