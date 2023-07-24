package AlgorithmTest.Baekjoon.BOJ11399;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] waitings = new int[N];
        for (int i = 0; i < N; i++) {
            waitings[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(waitings);

        int timeSum = 0;
        for (int i = 0; i < N; i++) {
            timeSum += waitings[i] * (N - i);
        }

        System.out.println(timeSum);
        br.close();
    }
}
