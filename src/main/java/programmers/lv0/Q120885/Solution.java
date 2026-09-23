package programmers.lv0.Q120885;

/**
 * date: 2026-09-23
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120885
 */
public class Solution {
    public String solution(String bin1, String bin2) {
        int n1 = Integer.parseInt(bin1, 2);
        int n2 = Integer.parseInt(bin2, 2);

        return Integer.toBinaryString(n1 + n2);
    }
}
