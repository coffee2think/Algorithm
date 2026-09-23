package programmers.lv2.Q42860;

import java.util.Arrays;

/**
 * date: 2024-05-02
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/42860
 */

public class Main {
    public static void main(String[] args) {
        // given
        String[] name = {"JEROEN", "JAN", "JAZ"};
        int[] answer = {56, 23, 11};

        // when
        int[] result = new int[name.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Main().solution(name[i]);
        }

        // then
        System.out.println("result: " + Arrays.toString(result) + " is " + (Arrays.equals(result, answer) ? "Correct!" : "Wrong.."));
    }

    public int solution(String name) {
        int answer = 0;

        // 완전 탐색?
        // 백트랙킹?

        int[] diff = new int[name.length()];
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            diff[i] = Math.min(ch - 'A', 26 - (ch - 'A'));
        }

        return answer;
    }
}
