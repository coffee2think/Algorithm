package programmers.lv2.sumofsubseries;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] elements = new int[]{7, 9, 1, 1, 4};
        System.out.println(solution(elements));
    }

    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        for (int n = 1; n <= len; n++) {
            for (int start = 0; start < len; start++) {
                int sum = 0, j = n;
                while (j-- > 0) {
                    sum += elements[(start + j) % len];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
