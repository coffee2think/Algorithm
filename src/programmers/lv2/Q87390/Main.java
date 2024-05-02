package src.programmers.lv2.Q87390;

import java.util.Arrays;

/**
 * date: 2024-05-02
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */

public class Main {
    public static void main(String[] args) {
        // given
        int n = 3;
        long left = 2;
        long right = 5;
        int[] answer = {3, 2, 2, 3};

        // when
        int[] result = new Main().solution(n, left, right);

        // then
        System.out.println("result: " + Arrays.toString(result) + " is " + (Arrays.equals(result, answer) ? "Correct!" : "Wrong.."));
    }

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < answer.length; i++) {
            int row = (int) ((left + i) / n) + 1;
            int col = (int) ((left + i) % n) + 1;
            answer[i] = Math.max(row, col);
        }

        return answer;
    }
}
