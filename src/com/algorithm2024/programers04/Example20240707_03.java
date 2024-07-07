package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example20240707_03 { // 베스트앨범

    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        List<int[]> temp = new ArrayList<>();
        Map<String, Integer> totalGenreD = new HashMap<>();

        // Create a list of [genre, play count, index]
        for (int i = 0; i < genres.length; i++) {
            temp.add(new int[] {i, plays[i], genres[i].hashCode()});
        }

        // Sort by genre first, then by play count (descending), then by index (ascending)
        temp.sort((a, b) -> {
            int genreCompare = Integer.compare(a[2], b[2]);
            if (genreCompare == 0) {
                int playCompare = Integer.compare(b[1], a[1]);
                if (playCompare == 0) {
                    return Integer.compare(a[0], b[0]);
                }
                return playCompare;
            }
            return genreCompare;
        });

        // Calculate the total play count for each genre
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            totalGenreD.put(genre, totalGenreD.getOrDefault(genre, 0) + playCount);
        }

        // Sort genres by total play count (descending)
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(totalGenreD.entrySet());
        sortedGenres.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // For each genre, add up to 2 song indices to the answer
        for (Map.Entry<String, Integer> entry : sortedGenres) {
            String genre = entry.getKey();
            int count = 0;
            for (int[] song : temp) {
                if (count >= 2) break;
                if (genres[song[0]].equals(genre)) {
                    answer.add(song[0]);
                    count++;
                }
            }
        }

        return answer;
    }

}
