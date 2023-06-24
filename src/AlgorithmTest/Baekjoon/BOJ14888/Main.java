package AlgorithmTest.Baekjoon.BOJ14888;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static int[] operations = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 0);
        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    public static void dfs(int accCalc, int depth) {
        if (depth == N - 1) {
            max = Math.max(accCalc, max);
            min = Math.min(accCalc, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operations[i] == 0) continue;

            operations[i]--;
            switch (i){
                case 0: dfs(accCalc + A[depth + 1], depth + 1); break;
                case 1: dfs(accCalc - A[depth + 1], depth + 1); break;
                case 2: dfs(accCalc *  A[depth + 1], depth + 1); break;
                case 3: dfs(accCalc / A[depth + 1], depth + 1); break;
            }
            operations[i]++;
        }
    }
}
