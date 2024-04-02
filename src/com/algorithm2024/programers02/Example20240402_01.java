package com.algorithm2024.programers02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example20240402_01 { //주차요금
    public static List<Integer> solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> in = new HashMap<>();
        Map<String, Integer> usingTime = new HashMap<>();
        Map<String, Integer> price = new HashMap<>();

        for(String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String name = split[1];
            String op = split[2];

            if(op.equals("IN")) {
                in.put(name, time);
            } else {
                int inTime = getTime(in.get(name));
                int outTime = getTime(time);

                usingTime.put(name, usingTime.getOrDefault(name, 0) + (outTime - inTime));
                in.remove(name);
            }
        }

        for(String name : in.keySet()) {
            int using = getTime("23:59") - getTime(in.get(name));
            usingTime.put(name, usingTime.getOrDefault(name, 0) + using);
        }

        for(String name : usingTime.keySet()) {
            int defaultTime = fees[0];
            int defaultFee = fees[1];
            int term = fees[2];
            int termFee = fees[3];

            int time = usingTime.get(name);

            if(time <= defaultTime) {
                price.put(name, defaultFee);
                continue;
            }

            time -= defaultTime;
            int charge = defaultFee;

            int div = time / term;
            int mod = time % term;

            charge += div * termFee;
            if(mod != 0) {
                charge += termFee;
            }

            price.put(name, charge);
        }

        return price.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    static int getTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600}; // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(solution(fees, records)); // 14600, 34400, 5000
    }
}
