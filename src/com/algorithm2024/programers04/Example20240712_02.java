package com.algorithm2024.programers04;

import java.util.*;

public class Example20240712_02 { //2018 KAKAO BLIND RECRUITMENT [1차] 캐시

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> cache = new LinkedHashSet<>(cacheSize);

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toUpperCase();
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1; // Cache hit
            } else {
                if (cache.size() == cacheSize) {
                    cache.iterator().next();
                    cache.remove(cache.iterator().next());
                }
                cache.add(city);
                answer += 5; // Cache miss
            }
        }

        return answer;
    }
}
