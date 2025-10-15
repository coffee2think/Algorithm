package src.baekjoon.BOJ25985;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/25985
// date: 2025-10-15
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        double p1 = (double) Integer.parseInt(st.nextToken()) / 100;
        double p2 = (double) Integer.parseInt(st.nextToken()) / 100;

        // when
        double index = (1 - 1 / p2) / (1 - 1 / p1);

        // then
        System.out.println(index);
        br.close();
    }
}
