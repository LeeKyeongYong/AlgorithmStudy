package com.algorithm2024.programers03;

import java.util.*;

public class Example20240628_01 {//기둥과 보 설치  2020 KAKAO BLIND RECRUITMENT
    private int n;
    private Set<Build> buildSet;

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        this.buildSet = new HashSet<>();

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int option = frame[3];

            Build build = new Build(x, y, type);

            if (option == 1) { // 설치
                if (canBuild(build)) {
                    buildSet.add(build);
                }
            } else { // 삭제
                buildSet.remove(build);
                if (!isSustainable()) {
                    buildSet.add(build);
                }
            }
        }

        List<Build> sortedBuildList = new ArrayList<>(buildSet);
        Collections.sort(sortedBuildList);

        int[][] answer = new int[sortedBuildList.size()][3];
        for (int i = 0; i < sortedBuildList.size(); i++) {
            Build build = sortedBuildList.get(i);
            answer[i][0] = build.x;
            answer[i][1] = build.y;
            answer[i][2] = build.type;
        }

        return answer;
    }

    private boolean isSustainable() {
        for (Build build : buildSet) {
            if (!canBuild(build)) {
                return false;
            }
        }
        return true;
    }

    private boolean canBuild(Build build) {
        int x = build.x;
        int y = build.y;
        int type = build.type;

        if (type == 0) { // 기둥
            return y == 0 || buildSet.contains(new Build(x, y - 1, 0)) ||
                    buildSet.contains(new Build(x - 1, y, 1)) ||
                    buildSet.contains(new Build(x, y, 1));
        } else { // 보
            return buildSet.contains(new Build(x, y - 1, 0)) ||
                    buildSet.contains(new Build(x + 1, y - 1, 0)) ||
                    (buildSet.contains(new Build(x - 1, y, 1)) &&
                            buildSet.contains(new Build(x + 1, y, 1)));
        }
    }

    private static class Build implements Comparable<Build> {
        int x;
        int y;
        int type;

        public Build(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, type);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Build other = (Build) obj;
            return x == other.x && y == other.y && type == other.type;
        }

        @Override
        public int compareTo(Build o) {
            if (this.x != o.x) return Integer.compare(this.x, o.x);
            if (this.y != o.y) return Integer.compare(this.y, o.y);
            return Integer.compare(this.type, o.type);
        }
    }
}
