package com.algorithm2024.programers01;

public class Exam20240223_02 {//거스름돈 2 (재기적으로 확인 효율성 없음..
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1, 2, 5};
        Solution004_2 s2=new Solution004_2();
        int result = s2.solution(n, money);
        System.out.println(result);
    }
}
class Solution004_2{
    static int answer = 0;

    public static void findWay(int n, int[] money, int count, int fro) {
        if (count == n) {
            answer += 1;
            answer = answer % 1000000007;
        }

        if (count > n) {
            return;
        } else {
            for (int i = fro; i < money.length; i++) {
                fro = i;
                findWay(n, money, count + money[i], fro);
            }
        }
    }

    public static int solution(int n, int[] money) {
        findWay(n, money, 0, 0);
        return answer;
    }
}