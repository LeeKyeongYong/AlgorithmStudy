package com.jababookbacojoon5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example20240914_q2141 {

    static class City {
        int pos;
        int people;

        public City(int pos, int people) {
            this.pos = pos;
            this.people = people;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<City> cities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cities.add(new City(sc.nextInt(), sc.nextInt()));
        }

        // 1. 위치 오름차순
        Collections.sort(cities, (o1, o2) -> Integer.compare(o1.pos, o2.pos));

        // 2. 전체 인구 수의 합을 계산
        long prefixSum = 0;
        for (City city : cities) {
            prefixSum += city.people;
        }

        // 3. 전체 사람 수 절반 (절반을 넘어가는 포지션이 정답이기 때문)
        // 우체국의 위치는 거리 딱 절반과 제일 가까운 위치가 되어야함
        long halfPeople = (prefixSum + 1) / 2;

        // 4. 사람 누적합 절반을 넘어가는 포지션을 발견하면 정답처리
        long peopleSum = 0;
        int answer = 0;
        for (City city : cities) {
            peopleSum += city.people;

            if (peopleSum >= halfPeople) {
                answer = city.pos;
                break;
            }
        }

        System.out.println(answer);
    }

}
