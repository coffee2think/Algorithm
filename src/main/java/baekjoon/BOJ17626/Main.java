package baekjoon.BOJ17626;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// link: https://www.acmicpc.net/problem/17626
// date: 2025-11-04
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(countSquareSum(n));
        br.close();
    }

    public static int countSquareSum(int n) {
        int s = (int) Math.sqrt(n);
        int minCount = 4;

        for (int i = s; i * i >= n / 2; i--) {
            minCount = Math.min(minCount, countSquareSum(n - i * i) + 1);
        }

        return minCount;
    }
}
