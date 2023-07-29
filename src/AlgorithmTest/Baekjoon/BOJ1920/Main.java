package AlgorithmTest.Baekjoon.BOJ1920;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] distances = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        int[] prices = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long bestCost = (long) prices[0] * distances[0];
        int minPrice = prices[0];
        for (int i = 1; i < N - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            bestCost += (long) minPrice * distances[i];
        }

        System.out.println(bestCost);
        br.close();
    }
}
