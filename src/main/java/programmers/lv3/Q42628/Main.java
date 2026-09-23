package programmers.lv3.Q42628;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

// link: https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
// date: 2025-10-10

public class Main {
    public static void main(String[] args) {
        // given
        String[][] operations = {
                {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"},
                {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
        };
        int[][] answer = {
                {0, 0},
                {333, -45}
        };

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Objects.deepEquals(solution(operations[i]), answer[i])) {
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
    // * 문제를 풀며 배운 점
    // -
    public static int[] solution(String[] operations) {
        int count = 0;
        int totalOperations = operations.length;
        Deque<Integer> deque = new ArrayDeque<>();


        int[] answer = {};
        return answer;
    }
}
