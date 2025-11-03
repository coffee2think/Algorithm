package src.baekjoon.BOJ15829;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// link: https://www.acmicpc.net/problem/15829
// date: 2025-11-04
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int M = 1234567891;
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long r = 1;
        long hash = str.charAt(0) - 'a' + 1;

        for (int i = 1; i < L; i++) {
            r = (r * 31) % M;
            hash += ((str.charAt(i) - 'a' + 1) * r) % M;
            hash %= M;
        }

        System.out.println(hash);
        br.close();
    }
}
