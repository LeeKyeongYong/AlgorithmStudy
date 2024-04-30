package com.algorithm2024.programers02;

import java.util.*;
import java.util.stream.Collectors;

public class Sample20240430_1 { //베스트앨범
    static class Album implements Comparable<Album> {
        int index;
        String genre;
        int play;

        public Album(final int index, final String genre, final int play) {
            this.index = index;
            this.genre = genre;
            this.play = play;
        }


        @Override
        public int compareTo(final Album o) {
            return o.play - this.play;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, List<Album>> albums = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);

            if (!albums.containsKey(genre)) {
                albums.put(genre, new ArrayList<>());
            }

            albums.get(genre).add(new Album(i, genre, play));
        }

        // map key 정렬 (value 내림차순)
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o2) - map.get(o1));

        List<Integer> answer = new ArrayList<>();

        for (String genre : keys) {
            List<Album> values = albums.get(genre);
            Collections.sort(values);

            List<Integer> filtered = values.stream()
                    .map(it -> it.index)
                    .limit(2)
                    .collect(Collectors.toList());


            answer.addAll(filtered);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "toga"};
        int[] plays = {500, 600, 150, 800, 2500, 5000};

        // 4, 1, 3, 0
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
