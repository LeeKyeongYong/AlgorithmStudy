package com.algorithm2024.letcode;

import java.util.ArrayList;
import java.util.List;

public class Example001_Q2092 {

    static int[] parsent;
    static List<Integer> answer;

    public List<Integer> findAllSearch(int n,int[][] meetings, int firstPerson){
        parsent = new int[n];
        answer = new ArrayList<>();

        for(int i=0; i<parsent.length; i++){
            parsent[i] = i;
        }
        unionPerson(0,firstPerson);

        //1. 시간순 정
    }

    public static void main(String[] args) {
        Example001_Q2092 leeky001 =new Example001_Q2092();

        //0,1,3,4
        System.out.println(leeky001.findAllSearch(5,new int[][]{{1,4,3},{0,4,3}},3));
    }
}
