package src.programmers.lv2.Q42746;

import java.util.PriorityQueue;

public class Main3 {
    public static void main(String[] args) {
        // given
        int[][] numbers = {
                {6, 10, 2},
                {30, 3, 34, 5, 9},
                {979, 97, 978, 81, 818, 817},
                {0, 0, 0, 0, 0}
        };

        String[] answer = {
                "6210",
                "9534330",
                "9799797881881817",
                "0"
        };

        // when
        String[] result = new String[answer.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Main().solution(numbers[i]);
        }

        // then
        for (int i = 0; i < result.length; i++) {
            System.out.println("result: " + result[i] + " is " + ((result[i].equals(answer[i])) ? "Correct!" : "Wrong.."));
        }
    }

    // 우선순위큐 이용하여 정렬하기
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        // Arrays.sort()를 사용하기 위한 String 배열 초기화
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });

        for (int n : numbers) {
            pq.add(String.valueOf(n));
        }

        // 모두 "0"일 경우 "0"을 리턴
        if (pq.peek().equals("0")) {
            return "0";
        }

        // 문자열 합치기
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        return sb.toString();
    }
}
