package src.programmers.lv2.Q42584;

// link: https://school.programmers.co.kr/learn/courses/30/lessons/42584?language=java
// date: 2025-10-09

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        // given
        int[][] prices = {
                {1, 2, 3, 2, 3}
        };
        int[][] answer = {
                {4, 3, 1, 1, 0}
        };

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Arrays.equals(solution(prices[i]), answer[i])) {
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
    public static int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] periods = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int topIndex = stack.pop();
                periods[topIndex] = i - topIndex;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            periods[topIndex] = (prices.length - 1) - topIndex;
        }

        return periods;
    }
}
