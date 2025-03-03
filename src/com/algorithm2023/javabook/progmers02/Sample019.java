package com.algorithm2023.javabook.progmers02;

public class Sample019 { // 가장 가까운 값
    public static void main(String[] args) {
        Solution19 s = new Solution19();
        //int []array = {3,10,28};
        //int n = 20;
        int []array = {10,11,12};
        int n = 13;
        int result = s.solution(array, n);
        System.out.println("가장 가까운 값: " + result);
    }
}
class Solution19 {
    public int solution(int[] array, int n) {
        int answer = 0;
        
        // 배열을 오름차순으로 정렬한다.
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= n) {
                int num1 = n - array[i - 1];
                int num2 = array[i] - n;
                
                // 두 값의 절대값이 같을 때에는 더 작은 값을 선택한다.
                if (num1 > num2) {
                    answer = array[i];
                    return answer;
                } else if (num1 < num2) {
                    answer = array[i - 1];
                    return answer;
                } else if (num1 == num2) {
                    answer = array[i - 1];
                    return answer;
                }
            }
        }
        
        // 가장 가까운 값이 없는 경우, 배열의 마지막 값이 가장 가까운 값이 된다.
        answer = array[array.length - 1];
        return answer;
    }
}