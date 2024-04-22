package src.programmers.lv2.Q42747;

import java.util.Arrays;

/**
 * Programmers Q42747 lv2
 * Problem name: H-Index
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */

public class Main {
    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
        int hIndex = 0;
        for (int h = 1; h <= len; h++) {
            if (citations[len - h] >= h) hIndex++;
            else break;
        }

        return hIndex;
    }
}
