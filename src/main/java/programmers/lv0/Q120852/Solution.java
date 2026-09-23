package programmers.lv0.Q120852;

import java.util.HashSet;
import java.util.Set;

/**
 * date: 2026-09-23
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120852?language=java
 */
public class Solution {
    public int[] solution1(int n) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                if (!set.contains(i)) {
                    set.add(i);
                }
            }
        }

        if (n > 1) {
            set.add(n);
        }

        answer = set.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}
