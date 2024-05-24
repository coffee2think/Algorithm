package src.baekjoon.BOJ4673;

/**
 * date: 2024-05-24
 * source: https://www.acmicpc.net/problem/4673
 */

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int[] count = new int[10001]; // 생성자 개수 카은트
        for (int i = 1; i <= 10000; i++) {
            int n = d(i);
            if (n <= 10000) {
                count[n]++;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (count[i] == 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
