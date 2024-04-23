package src.baekjoon.BOJ23812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon Q23812 브론즈3
 * Problem name: 골뱅이 찍기 - 돌아간 ㅍ
 * link: https://www.acmicpc.net/problem/23812
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String type1 = "@".repeat(N) + "   ".repeat(N) + "@".repeat(N);
        String type2 = "@@@@@".repeat(N);

        for (int line = 0; line < 5; line++) {
            for (int i = 0; i < N; i++) {
                sb.append(line % 2 == 0 ? type1 : type2).append("\n");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
