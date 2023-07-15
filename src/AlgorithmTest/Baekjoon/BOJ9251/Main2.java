package Baekjoon.BOJ9251;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] seq1 = br.readLine().toCharArray();
        char[] seq2 = br.readLine().toCharArray();
        int[][] lcs = new int[seq1.length + 1][seq2.length + 1];

        int m = seq1.length;
        int n = seq2.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seq1[i] == seq2[j]) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1;
                } else {
                    lcs[i + 1][j + 1] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
                }
            }
        }

        System.out.println(lcs[m][n]);

        br.close();
    }
}