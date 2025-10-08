package src.programmers.lv1.Q12906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 3, 3, 0, 1, 1},
                {4, 4, 4, 3, 3}
        };

        int[][] answer = {
                {1, 3, 0, 1},
                {4, 3}
        };

        int total = arr.length;
        int answerCount = 0;
        for (int i = 0; i < total; i++) {
            if (Arrays.equals(solution(arr[i]), answer[i])) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, total, ((double)answerCount / total * 100));
    }

    public static int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();

        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != prev) {
                answerList.add(arr[i]);
                prev = arr[i];
            }
        }

        int[] answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}
