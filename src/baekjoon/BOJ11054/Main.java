package src.baekjoon.BOJ11054;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dpAsc = new int[N];
        int[] dpDesc = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < seq.length; i++) {
            int ri = N - 1 - i;

            dpAsc[i] = 1;
            dpDesc[ri] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dpAsc[i] < dpAsc[j] + 1) {
                    dpAsc[i] = dpAsc[j] + 1;
                }
            }

            for (int j = N - 1; j > ri; j--) {
                if (seq[j] < seq[ri] && dpDesc[ri] < dpDesc[j] + 1) {
                    dpDesc[ri] = dpDesc[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < dpAsc.length; i++) {
            int bitonicLength = dpAsc[i] + dpDesc[i] - 1;
            if (bitonicLength > maxLength) {
                maxLength = bitonicLength;
            }
        }

        System.out.println(maxLength);
        br.close();
    }
}
