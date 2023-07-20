package AlgorithmTest.Baekjoon.BOJ16139;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] psum = new int[26][str.length() + 1];

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                psum[j][i] = psum[j][i - 1] + (str.charAt(i - 1) - 'a' == j ? 1 : 0);
            }
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken()) + 1;
            int end = Integer.parseInt(st.nextToken()) + 1;

            sb.append(psum[alpha - 'a'][end] - psum[alpha - 'a'][start - 1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
