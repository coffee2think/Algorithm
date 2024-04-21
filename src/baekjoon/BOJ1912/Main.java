package src.baekjoon.BOJ1912;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] accSum = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = accSum[0] = arr[0];
        for (int i = 1; i < accSum.length; i++) {
            accSum[i] = Math.max(accSum[i - 1] + arr[i], arr[i]);
            if (accSum[i] > max) max = accSum[i];
        }

        System.out.println(max);
        br.close();
    }
}
