package com.jababookbackjoon4;

public class Example20240826_BaseStationInstaller {//기지국설치 알고리즘

//    static class Section {
//        // start <= X < end
//
//        int start;
//        int end;
//
//        public Section(final int start, final int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//        @Override
//        public String toString() {
//            return "Section{" +
//                    "start=" + start +
//                    ", end=" + end +
//                    '}';
//        }
//    }
//
//    public int solution(int n, int[] stations, int w) {
//        int answer = 0;
//
//        List<Section> sections = new ArrayList<>();
//
//        int before = 1;
//        for (int station : stations) {
//            sections.add(new Section(before, station - w));
//            before = station + w + 1;
//        }
//
//        if (before <= n) {
//            sections.add(new Section(before, n + 1));
//        }
//        System.out.println(sections);
//
//        for (Section section : sections) {
//            int startContains = section.start;
//            int endNotContains = section.end;
//            int range = endNotContains - startContains;
//
//            int needToBuild = range / (2 * w + 1);
//            if (range % (2 * w + 1) != 0) {
//                needToBuild++;
//            }
//
//            answer += needToBuild;
//        }
//
//        return answer;
//    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 1;
        int stationIndex = 0;

        while (now <= n) {
            // 현재 위치가 기존 기지국 커버 범위 내에 있는 경우
            if (stationIndex < stations.length && now >= stations[stationIndex] - w) {
                now = stations[stationIndex] + w + 1;
                stationIndex++;
            } else {
                // 현재 위치가 기지국 커버 범위 밖에 있는 경우
                answer++;
                now += 2 * w + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Example20240826_BaseStationInstaller sol = new Example20240826_BaseStationInstaller();

        // 3
        System.out.println(sol.solution(11, new int[]{4, 11}, 1));

        // 3
        System.out.println(sol.solution(16, new int[]{9}, 2));


        // 1 [2 3 4] 5 [6 7 8] 9 [10 11 12] 13
        // 4
        System.out.println(sol.solution(13, new int[]{3, 7, 11}, 1));
    }
}
