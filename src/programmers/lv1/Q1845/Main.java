package src.programmers.lv1.Q1845;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[][] nums = {
                {3,1,2,3},
                {3,3,3,2,2,4},
                {3,3,3,2,2,2}
        };

        int[] answer = {
                2,
                3,
                2
        };

        int total = nums.length;
        int answerCount = 0;
        for (int i = 0; i < total; i++) {
            if (solution(nums[i]) == answer[i]) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, total, ((double)answerCount / total * 100));
    }

    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return Math.min(map.size(), nums.length / 2);
    }
}
