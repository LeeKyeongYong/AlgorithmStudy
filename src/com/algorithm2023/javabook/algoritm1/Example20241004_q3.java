package com.algorithm2023.javabook.algoritm1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example20241004_q3 {
    static class Date {
        private LocalDateTime localDateTime;

        public Date(final String s) {
            String[] split = s.split(":");

            this.localDateTime = LocalDateTime.of(
                    Integer.parseInt(split[0]),
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]),
                    Integer.parseInt(split[3]),
                    Integer.parseInt(split[4]),
                    Integer.parseInt(split[5])
            );
        }

        public Date(final LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void addTime(final String s) {
            String[] split = s.split(":");

            localDateTime = localDateTime
                    .plusDays(Integer.parseInt(split[0]))
                    .plusHours(Integer.parseInt(split[1]))
                    .plusMinutes(Integer.parseInt(split[2]))
                    .plusSeconds(Integer.parseInt(split[3]));
        }
    }

    public static int[] solution(String s, String[] times) {
        int[] answer = new int[2];
        boolean isDone = true;

        // 1. 날짜 더하면서 list로 저장
        Date startDate = new Date(s);
        List<LocalDateTime> list = new ArrayList<>();
        list.add(startDate.getLocalDateTime());
        LocalDateTime now = startDate.getLocalDateTime();

        for (String time : times) {
            Date nextDate = new Date(now);
            nextDate.addTime(time);
            list.add(nextDate.getLocalDateTime());
            now = nextDate.getLocalDateTime();
        }

        // 2. 정답 구하기
        LocalDateTime beforeDate = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            LocalDateTime nowDate = list.get(i);

            long daysBetween = Duration.between(
                    beforeDate.toLocalDate().atStartOfDay(),
                    nowDate.toLocalDate().atStartOfDay()
            ).toDays();

            // 2일 이상이라면 false
            if (daysBetween >= 2) {
                isDone = false;
                break;
            }

            beforeDate = nowDate;
        }

        long savingPeriod = Duration.between(
                list.get(0).toLocalDate().atStartOfDay(),
                list.get(list.size() - 1).toLocalDate().atStartOfDay()
        ).toDays() + 1;

        answer[0] = isDone ? 1 : 0;
        answer[1] = (int) savingPeriod;

        return answer;
    }

    public static void main(String[] args) {
        // 0, 4
        System.out.println(Arrays.toString(Example20241004_q3.solution(
                "2021:04:12:16:08:35",
                new String[]{"01:06:30:00", "01:04:12:00"}
        )));
    }
}
