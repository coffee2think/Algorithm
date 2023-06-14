package programmers.makeMinCombSum;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] A = {5, 4, 4};
        int[] B = {1, 4, 2}; // 5 16 8

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int sum1 = 0, sum2 = 0;
        int len = A.length;

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < len; i++) {
            sum1 += A[i] * B[i];
            sum2 += A[i] * B[len - 1 - i];
        }

        return Math.min(sum1, sum2);
    }
}
