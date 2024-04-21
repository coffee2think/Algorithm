package src.baekjoon.BOJ16430;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon Q16430 브론즈5
 * Problem name: 제리와 톰
 * link: https://www.acmicpc.net/problem/16430
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println((B - A) + " " + B);
        br.close();
    }
}
