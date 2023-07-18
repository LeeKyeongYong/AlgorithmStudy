package com.jababookbackjoon2;

public class Sample005 { //백준 15586 정수N개의 합 (실제 답안을 작성할때 Main명이아닌 Test명으로해야한다)
	 public long sum(int[] a) {
	        long ans = 0;
	        for (int i = 0; i < a.length; ++i) {
	            ans += a[i];
	        }
	        return ans;
	  }
}
/*
 문제>>
 정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.

작성해야 하는 함수는 다음과 같다.

C, C11, C (Clang), C11 (Clang): long long sum(int *a, int n);
a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
n: 합을 구해야 하는 정수의 개수
리턴값: a에 포함되어 있는 정수 n개의 합
C++, C++11, C++14, C++17, C++ (Clang), C++11 (Clang), C++14 (Clang), C++17 (Clang): long long sum(std::vector<int> &a);
a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
리턴값: a에 포함되어 있는 정수 n개의 합
Python 2, Python 3, PyPy, PyPy3: def solve(a: list) -> int
a: 합을 구해야 하는 정수 n개가 저장되어 있는 리스트 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
리턴값: a에 포함되어 있는 정수 n개의 합 (정수)
Java: long sum(int[] a); (클래스 이름: Test)
a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
리턴값: a에 포함되어 있는 정수 n개의 합
Go: sum(a []int) int
a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
리턴값: a에 포함되어 있는 정수 n개의 합

 
 느낀점: 코드를 좀더 이쁘게 짜고싶어서 main함수 적용하고했으나... 문제를 제출한 시점에서.. 답은 이미 정해져있는것같고.. 똑같은 답을 내면.. 의마가있는가 싶은생각도 들었다..
        그래도 한번 더 생각해보는 시간을 갖아본것같다.
 */