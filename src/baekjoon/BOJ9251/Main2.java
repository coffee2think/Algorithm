package src.baekjoon.BOJ9251;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    static List<Character> lcsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] seq1 = br.readLine().toCharArray();
        char[] seq2 = br.readLine().toCharArray();
        int m = seq1.length, n = seq2.length;

        int[][] lcs = new int[m + 1][n + 1];
        int[][] route = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seq1[i] == seq2[j]) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1;
                    route[i + 1][j + 1] = 1;
                } else {
                    lcs[i + 1][j + 1] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
                    route[i + 1][j + 1] = (lcs[i + 1][j] > lcs[i][j + 1]) ? 2 : 3;
                }
            }
        }

        System.out.println(lcs[m][n]);

        // LCS 원소 출력
        getLcs(m, n, route, seq1);
        System.out.println(lcsList);

        br.close();
    }

    public static void getLcs(int i, int j, int[][] route, char[] seq) {
        if(i == 0 || j == 0) return;

        switch (route[i][j]){
            case 1:
                lcsList.add(0, seq[i - 1]);
                getLcs(i - 1, j - 1, route, seq);
                break;
            case 2:
                getLcs(i, j - 1, route, seq);
                break;
            case 3:
                getLcs(i - 1, j, route, seq);
                break;
        }
    }
}
