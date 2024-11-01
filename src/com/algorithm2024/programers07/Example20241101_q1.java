package com.algorithm2024.programers07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example20241101_q1 {

    static int n;
    static List<String> routes;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        n = tickets.length;
        routes = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String start = ticket[0];
            String end = ticket[1];

            if (start.equals("ICN")) {
                visited[i] = true;
                permutation(1, "ICN," + end, tickets);
                visited[i] = false;
            }
        }

        Collections.sort(routes);
        return routes.get(0).split(",");
    }

    static void permutation(int index, String route, String[][] tickets) {
        if (index == tickets.length) {
            routes.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) {
                continue;
            }

            String[] ticket = tickets[i];
            String start = ticket[0];
            String end = ticket[1];

            if (route.endsWith(start)) {
                visited[i] = true;
                permutation(index + 1, route + "," + end, tickets);
                visited[i] = false;
            }
        }
    }

}
