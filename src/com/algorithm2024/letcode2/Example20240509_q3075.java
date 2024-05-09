package com.algorithm2024.letcode2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Example20240509_q3075 {
    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long answer = 0;
        int remain = 0;

        for (int i = happiness.length - 1; i >= happiness.length - k; i--) {
            int now = happiness[i] - remain;
            remain++;

            if (now >= 1) {
                answer += now;
            }
        }

        return answer;
    }

    public long failVersionCauseTimeOver(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (int) o2 - o1);
        int answer = 0;

        for (int i : happiness) {
            pq.add(i);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            long pick = pq.poll();

            if (pick <= 0) {
                break;
            }

            answer += pick;
            PriorityQueue<Integer> temp = new PriorityQueue<>((o1, o2) -> o2 - o1);
            while (!pq.isEmpty()) {
                int now = pq.poll();
                if (now != 0) {
                    temp.add(now - 1);
                }
            }

            pq = temp;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {2135218, 73431904, 92495076, 77528042, 82824634, 3036629, 28375907, 65220365, 40948869, 58914871, 57169530, 89783499, 19582915, 19676695, 11932465, 21770144, 49740276, 22303751, 80746555, 97391584, 95775653, 43396943, 47271136, 43935930, 59643137, 64183008, 8892641, 39587569, 85086654, 5663585, 82925096, 24868817, 95900395, 48155864, 74447380, 7618448, 63299623, 91141186, 33347112, 81951555, 52867615, 92184410, 7024265, 85525916, 29846922, 59532692, 47267934, 6514603, 1137830, 97807470};
        // 2517853814
        System.out.println(maximumHappinessSum(a, 41));
    }
}
