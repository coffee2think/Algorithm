package programmers.lv2.hindex;

import java.util.Arrays;

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
