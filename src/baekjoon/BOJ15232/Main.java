package src.baekjoon.BOJ15232;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// link: https://www.acmicpc.net/problem/15232
// date: 2025-10-31
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        System.out.println(("*".repeat(C) + "\n").repeat(R));
        br.close();
    }
}
