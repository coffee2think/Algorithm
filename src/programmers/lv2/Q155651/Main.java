package src.programmers.lv2.Q155651;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Programmers 155651 lv2
 * Problem name: 호텔 대실
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/155651
 */

public class Main {
    public static void main(String[] args) {
        String[][] book_time = new String[][]{
                {"15:00", "17:00"},
                {"16:40", "18:20"},
                {"14:20", "15:20"},
                {"14:10", "19:20"},
                {"18:20", "21:20"}
        };

        int result = 3;

        System.out.println(new Main().solution(book_time));

    }

    public int solution(String[][] book_time) {
        // 예약 시간이 주어졌을 때
        // 예약 시간이 겹치지 않도록 하는 최소 객실의 수를 구하라

        // 1. 주어진 배열을 시작 시간을 기준으로 정렬한다.
        // 2. 시작 시간이 같은 경우 종료 시간을 기준으로 정렬한다.
        // 3. 그리디 알고리즘을 이용하여 문제를 해결한다.

        Arrays.sort(book_time, (t1, t2) -> {
            // 시작 시간이 같을 경우 종료 시간을 기준으로 오름차순 정렬
            if (convertTime(t1[0]) == convertTime(t2[0])) {
                return convertTime(t1[1]) - convertTime(t2[1]);
            }

            // 시작 시간을 기준으로 오름차순 정렬
            return convertTime(t1[0]) - convertTime(t2[0]);
        });

        // 최소힙. 종료 시간을 기준으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 0;

        for (int i = 0; i < book_time.length; i++) {
            // 청소시간 10분 포함하여 종료시간을 우선순위큐에 추가
            pq.add(convertTime(book_time[i][1]) + 10);

            // 현재 예약 시간이 가장 빨리 끝나는 시간보다 늦게 시작한다면 큐에서 제거하고
            // 그렇지 않다면 끝난 객실이 없으므로 객실을 추가한다.
            if (convertTime(book_time[i][0]) >= pq.peek()) {
                pq.poll();
            } else {
                rooms++;
            }
        }

        return rooms;
    }

    // 주어진 시간 문자열을 분으로 환산하는 메소드
    public int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
