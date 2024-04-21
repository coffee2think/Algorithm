package src.baekjoon.BOJ11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.replace(sb.length()-2, sb.length(), ">");
        System.out.println(sb);
    }
}
