package com.algorithm2024.programers04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example20240708_04 { //2019 KAKAO BLIND RECRUITMENT 매칭 점수

    public int solution(String word, String[] pages) {
        List<WebPage> webPages = new ArrayList<>();
        Map<String, Integer> urlToIndex = new HashMap<>();
        Map<String, List<String>> linkGraph = new HashMap<>();

        String lowerWord = word.toLowerCase();
        Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S+)\"");
        Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
        Pattern linkPattern = Pattern.compile("<a href=\"(https://[^\"]+)\"");

        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];
            Matcher urlMatcher = urlPattern.matcher(page);
            urlMatcher.find();
            String url = urlMatcher.group(1);

            int basicScore = 0;
            Matcher wordMatcher = wordPattern.matcher(page.toLowerCase());
            while (wordMatcher.find()) {
                if (wordMatcher.group().equals(lowerWord)) {
                    basicScore++;
                }
            }

            List<String> externalLinks = new ArrayList<>();
            Matcher linkMatcher = linkPattern.matcher(page);
            while (linkMatcher.find()) {
                externalLinks.add(linkMatcher.group(1));
            }

            webPages.add(new WebPage(url, basicScore, externalLinks.size()));
            urlToIndex.put(url, i);

            for (String link : externalLinks) {
                linkGraph.computeIfAbsent(link, k -> new ArrayList<>()).add(url);
            }
        }

        double maxScore = 0;
        int resultIndex = 0;

        for (int i = 0; i < webPages.size(); i++) {
            WebPage page = webPages.get(i);
            double score = page.basicScore;

            if (linkGraph.containsKey(page.url)) {
                for (String link : linkGraph.get(page.url)) {
                    int index = urlToIndex.get(link);
                    WebPage linkedPage = webPages.get(index);
                    score += (double) linkedPage.basicScore / linkedPage.externalLinksCount;
                }
            }

            if (score > maxScore) {
                maxScore = score;
                resultIndex = i;
            }
        }

        return resultIndex;
    }

    static class WebPage {
        String url;
        int basicScore;
        int externalLinksCount;

        WebPage(String url, int basicScore, int externalLinksCount) {
            this.url = url;
            this.basicScore = basicScore;
            this.externalLinksCount = externalLinksCount;
        }
    }

}
