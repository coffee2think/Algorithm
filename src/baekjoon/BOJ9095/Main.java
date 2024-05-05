package src.baekjoon.BOJ9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/9095
 */

// brute force 풀이
public class Main {
    static int[] cases = new int[11];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        System.out.println("반복문 실행 횟수: " + count);

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(cases[n]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void init() {
        for (int n = 1; n <= 10; n++) {
            cases[n] = partitioning(n);
        }
    }

    public static int partitioning(int n) {
        return partitioning(n, new Stack<>());
    }

    public static int partitioning(int n, Stack<Integer> stack) {
        if (n < 1) {
            count++;
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= Math.min(3, n); i++) {
            stack.push(i);
            count += partitioning(n - i, stack);
            stack.pop();
        }

        return count;
    }
}
