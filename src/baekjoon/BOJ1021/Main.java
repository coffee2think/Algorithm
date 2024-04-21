package src.baekjoon.BOJ1021;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] selection = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            selection[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            deque.offerLast(i);

        int curIdx = 0;
        int accCnt = 0;
        while(curIdx != selection.length) {
            int cnt = 0;
            while (deque.peekFirst() != selection[curIdx]) {
                deque.offerLast(deque.pollFirst());
                cnt++;
            }
            accCnt += Math.min(cnt, deque.size() - cnt);
            deque.pollFirst();
            curIdx++;
        }

        System.out.println(accCnt);
        br.close();
    }
}
