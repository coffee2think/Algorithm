package programmers.lv0.Q120852;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * date: 2026-09-23
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120852?language=java
 */
public class Solution {
    public int[] solution1(int n) {
        int[] answer = {};
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);

                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        answer = factors.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    public int[] solution2(int n) {
        int[] answer = {};
        Set<Integer> factors = new HashSet<>();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);

                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        answer = factors.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();

        return answer;
    }
}
