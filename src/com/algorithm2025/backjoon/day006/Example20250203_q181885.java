package com.algorithm2025.backjoon.day006;

import java.util.ArrayList;

public class Example20250203_q181885 { //코딩테스트 연습 코딩 기초 트레이닝 할 일 목록


    public String[] solution(String[] todo_list, boolean[] finished) {
        // 아직 마치지 못한 일을 담을 ArrayList
        ArrayList<String> unFinishedTasks = new ArrayList<>();

        // todo_list를 순회하면서 finished가 false인 경우 해당 일을 unFinishedTasks에 추가
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) {
                unFinishedTasks.add(todo_list[i]);
            }
        }

        // ArrayList를 String 배열로 변환하여 반환
        return unFinishedTasks.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Example20250203_q181885 solution = new Example20250203_q181885();

        String[] todoList1 = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished1 = {true, false, true, false};
        String[] result1 = solution.solution(todoList1, finished1);
        System.out.println(java.util.Arrays.toString(result1)); // ["practiceguitar", "studygraph"]
    }
}
