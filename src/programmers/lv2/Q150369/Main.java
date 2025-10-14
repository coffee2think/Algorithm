package src.programmers.lv2.Q150369;


import java.util.Objects;

// link: https://school.programmers.co.kr/learn/courses/30/lessons/150369?language=java
// date: 2025-10-10
public class Main {
    public static void main(String[] args) {
        // given
        int[] cap = {4, 2};
        int[] n = {5, 7};
        int[][] deliveries = {
                {1, 0, 3, 1, 2},
                {1, 0, 2, 0, 1, 0, 2}
        };
        int[][] pickups = {
                {0, 3, 0, 4, 0},
                {0, 2, 0, 1, 0, 2, 0}
        };
        long[] answer = {16, 30};

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Objects.deepEquals(solution(cap[i], n[i], deliveries[i], pickups[i]), answer[i])) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        // then
        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2025-10-10
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int distantIndexD = nextDistantIndex(deliveries, n - 1);
        int distantIndexP = nextDistantIndex(pickups, n - 1);
        long distance = 0;
        while (distantIndexD > -1 || distantIndexP > -1) {
            distance += Math.max(distantIndexD + 1, distantIndexP + 1) * 2;

            // go
            int capacity = cap;
            while (distantIndexD > -1 && capacity > 0) {
                int able = Math.min(deliveries[distantIndexD], capacity);
                deliveries[distantIndexD] -= able;
                capacity -= able;
                if (deliveries[distantIndexD] == 0) {
                    distantIndexD = nextDistantIndex(deliveries, distantIndexD);
                }
            }

            // back
            capacity = cap;
            while (distantIndexP > -1 && capacity > 0) {
                int able = Math.min(pickups[distantIndexP], capacity);
                pickups[distantIndexP] -= able;
                capacity -= able;
                if (pickups[distantIndexP] == 0) {
                    distantIndexP = nextDistantIndex(pickups, distantIndexP);
                }
            }
        }

        return distance;
    }

    public static int nextDistantIndex(int[] array, int startIdx) {
        while (startIdx >= 0 && array[startIdx] == 0) {
            startIdx--;
        }
        return startIdx;
    }
}
