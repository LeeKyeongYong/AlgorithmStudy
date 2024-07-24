package com.algorithm2024.programers04;

import java.util.*;

public class Example20240725_03 { //2022 KAKAO BLIND RECRUITMENT 주차 요금 계산
    public static int[] solution(int[] fees, String[] records) {
        final int BASIC_MINUTE = fees[0];
        final int BASIC_FEE = fees[1];
        final int MINUTE_UNIT = fees[2];
        final int UNIT_FEE = fees[3];

        Map<String, Integer> totalMinutes = new HashMap<>();
        Map<String, String> entryTimes = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String status = parts[2];

            if (status.equals("IN")) {
                entryTimes.put(carNumber, time);
            } else {
                int parkedMinutes = calculateMinutes(entryTimes.get(carNumber), time);
                totalMinutes.put(carNumber, totalMinutes.getOrDefault(carNumber, 0) + parkedMinutes);
                entryTimes.remove(carNumber);
            }
        }

        // Handle cars that are still parked at end of the day
        final int END_OF_DAY = 1439; // 23:59 in minutes
        for (Map.Entry<String, String> entry : entryTimes.entrySet()) {
            int parkedMinutes = calculateMinutes(entry.getValue(), convertMinutesToTime(END_OF_DAY));
            totalMinutes.put(entry.getKey(), totalMinutes.getOrDefault(entry.getKey(), 0) + parkedMinutes);
        }

        // Calculate fees
        List<int[]> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalMinutes.entrySet()) {
            int totalMinutesParked = entry.getValue();
            int fee;
            if (totalMinutesParked <= BASIC_MINUTE) {
                fee = BASIC_FEE;
            } else {
                fee = BASIC_FEE + (int) Math.ceil((totalMinutesParked - BASIC_MINUTE) / (double) MINUTE_UNIT) * UNIT_FEE;
            }
            result.add(new int[]{Integer.parseInt(entry.getKey()), fee});
        }

        // Sort by car number and extract fees
        result.sort(Comparator.comparingInt(a -> a[0]));
        return result.stream().mapToInt(a -> a[1]).toArray();
    }

    private static int calculateMinutes(String startTime, String endTime) {
        int startMinutes = convertTimeToMinutes(startTime);
        int endMinutes = convertTimeToMinutes(endTime);
        return endMinutes - startMinutes;
    }

    private static int convertTimeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static String convertMinutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }

}
