package src.baekjoon.BOJ5532;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-04-30
 * source: https://www.acmicpc.net/problem/5532
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        System.out.println(L - Math.max((A + C - 1) / C, (B + D - 1) / D));
        br.close();
    }
}
