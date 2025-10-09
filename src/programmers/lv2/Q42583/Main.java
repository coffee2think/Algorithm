package src.programmers.lv2.Q42583;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

// link: https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java
// date: 2025-10-09

public class Main {
    public static void main(String[] args) {
        // given
        int[] bridge_length = {
                2,
                100,
                100
        };
        int[] weight = {
                10,
                100,
                100
        };
        int[][] truck_weights = {
                {7, 4, 5, 6},
                {10},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
        };
        int[] answer = {
                8,
                101,
                110
        };

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (solution(bridge_length[i], weight[i], truck_weights[i]) == answer[i]) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        // then
        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2025-10-09
    public static int solution(int bridge_length, int maxWeight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>(Collections.nCopies(bridge_length, 0));

        int time = 0;
        int bridgeWeight = 0;
        for (int truck : truck_weights) {
            do {
                bridgeWeight -= bridge.pollFirst();
                bridge.offerLast(0);
                time++;
            } while (bridgeWeight + truck > maxWeight);

            bridge.pollLast(); // 마지막에 집어넣은 0 제거
            bridge.offerLast(truck);
            bridgeWeight += truck;
        }

        time += bridge_length; // 마지막에 집어넣은 후, 다리 길이만큼 시간이 지나야 마지막 트럭이 건너짐
        return time;
    }
}
