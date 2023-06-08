package AlgorithmTest.Baekjoon.BOJ11050;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(comb(N, K));
    }

    public static int comb(int n, int r) {
        if(r == n || r == 0)
            return 1;
        else
            return comb(n - 1, r - 1) + comb(n - 1, r);
    }
}