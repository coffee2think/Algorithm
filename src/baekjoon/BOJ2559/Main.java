package src.baekjoon.BOJ2559;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temperature = new int[N + 1];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < temperature.length; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + temperature[i];
        }

        int max = sum[K];
        for (int i = 1; i < sum.length - K; i++) {
            max = Math.max(max, sum[K + i] - sum[i]);
        }

        System.out.println(max);
        br.close();
    }
}
