package Baekjoon.BOJ9251;

import java.io.*;

public class Main {
    static char[] seq1;
    static char[] seq2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        seq1 = br.readLine().toCharArray();
        seq2 = br.readLine().toCharArray();

        System.out.println(LCS(seq1.length - 1, seq2.length - 1));

        br.close();
    }

    public static int LCS(int i, int j) {
        if (i == -1 || j == -1) return 0;

        if (seq1[i] == seq2[j]) {
            return LCS(i - 1, j - 1) + 1;
        } else {
            return Math.max(LCS(i, j - 1), LCS(i - 1, j));
        }
    }
}
