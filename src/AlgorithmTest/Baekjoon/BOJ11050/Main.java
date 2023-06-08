package AlgorithmTest.Baekjoon.BOJ11050;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(comb(N, K));
    }

    public static BigInteger comb(int n, int k) {
        BigInteger result = new BigInteger(String.valueOf(1));
        int sub_k = k;
        if (sub_k > n / 2) {
            sub_k = n - k;
        }

        for (int i = n; i > n - sub_k; --i) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        for (int i = 1; i <= sub_k; ++i) {
            result = result.divide(new BigInteger(String.valueOf(i)));
        }
        return result;
    }
}