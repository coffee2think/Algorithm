package src.baekjoon.BOJ31403;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// link: https://www.acmicpc.net/problem/31403
// date: 2025-11-03
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int numResult = A + B - C;
        int strResult = Integer.parseInt("" + A + B) - C;

        System.out.println(numResult + "\n" + strResult);
        br.close();
    }
}
