package com.algorithm2024.programers04;

import java.util.Arrays;

public class Example20240701_03 { // 뒤에서 5등 위로

    public int[] solution(int[] num_list) {
        // 배열 정렬
        Arrays.sort(num_list);

        // 가장 작은 5개의 숫자를 제외한 나머지 숫자들을 새로운 배열로 반환
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }
}
