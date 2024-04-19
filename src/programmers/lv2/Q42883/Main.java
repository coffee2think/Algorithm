package src.programmers.lv2.Q42883;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Programmers Q42883 lv2
 * Problem name: 큰 수 만들기
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */

public class Main {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        String answer = "775841";

        long before1 = System.nanoTime();
        String result1 = new Main().solution1(number, k);
        long after1 = System.nanoTime();

        System.out.println("number: " + number + ", result: " + result1 + " is " + (result1.equals(answer) ? "Correct!" : "Wrong.."));
        System.out.println("Time: " + (after1 - before1) + "ns");
        System.out.println("Time: " + (after1 - before1) / 1_000_000.0 + "ms");

        long before2 = System.nanoTime();
        String result2 = new Main().solution2(number, k);
        long after2 = System.nanoTime();

        System.out.println("number: " + number + ", result: " + result2 + " is " + (result2.equals(answer) ? "Correct!" : "Wrong.."));
        System.out.println("Time: " + (after2 - before2) + "ns");
        System.out.println("Time: " + (after2 - before2) / 1_000_000.0 + "ms");

    }

    public String solution1(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int cnt = k;

        // 덱을 스택처럼 사용
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';

            while (!deque.isEmpty() && deque.getLast() < n && cnt-- > 0) {
                deque.pollLast();
            }

            deque.offerLast(n);
        }

        // 덱을 큐처럼 사용
        // k개 제거한 개수만큼 문자열에 추가
        for (int i = 0; i < number.length() - k; i++) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }

    public String solution2(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int max = 0;

        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = idx; j <= i + k; j++) {
                int num = number.charAt(j) - '0';
                if (max < num) {
                    max = num;
                    idx = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}
