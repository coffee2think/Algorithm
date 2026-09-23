package programmers.lv0.Q120843;

/**
 * date: 2026-09-23
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120843
 */
public class Solution {
    public int solution(int[] numbers, int k) {
        return 2 * (k - 1) % numbers.length + 1;
    }
}
