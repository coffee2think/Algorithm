package src.baekjoon.BOJ1037;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] properDivisor = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            properDivisor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(properDivisor);
        System.out.println(properDivisor[0] * properDivisor[n - 1]);
        br.close();
    }
}