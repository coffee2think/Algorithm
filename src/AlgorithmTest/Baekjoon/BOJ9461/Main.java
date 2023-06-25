package AlgorithmTest.Baekjoon.BOJ9461;

import java.io.*;

public class Main {
    static long[] seq = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        seq[1] = seq[2] = seq[3] = 1L;
        seq[4] = seq[5] = 2L;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(P(N)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static long P(int n) {
        if(seq[n] != 0) return seq[n];

        return seq[n] = P(n-1) + P(n-5);
    }
}
