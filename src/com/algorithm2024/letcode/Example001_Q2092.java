package com.algorithm2024.letcode;

import java.util.ArrayList;
import java.util.Arrays;
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

        //1. 시간순 정렬
        Arrays.sort(meetings,(o1,o2) -> {
            if(o1[2]==o2[2]){
                return o1[0] - o2[0];
            }

            return o1[2] -o2[2];

        });

        // 2.유니온 파인드
        for(int[] metting:meetings){
            int x = find(metting[0]);
            int y = find(metting[1]);

            if(x==0||y==0){
                unionPerson(x,y);
            }
        }

        for(int i=0; i<parsent.length; i++){
            if(parsent[i]==0){
                answer.add(i);
            }
        }
        return answer;
    }

    static int find(int temp){
        if(parsent[temp]!=temp){
            return find(parsent[temp]);
        }
        return temp;
    }

    static void unionPerson(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx > fy){
            parsent[x] = fy;
        } else {
            parsent[y] = fx;
        }
    }

    public static void main(String[] args) {
        Example001_Q2092 leeky001 =new Example001_Q2092();

        //0,1,3,4
        System.out.println(leeky001.findAllSearch(5,new int[][]{{1,4,3},{0,4,3}},3));

        //        System.out.println(sol.findAllPeople(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1));
    }
}
