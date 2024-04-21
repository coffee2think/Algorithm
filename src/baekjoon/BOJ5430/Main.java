package src.baekjoon.BOJ5430;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), ",[]");
            for (int j = 0; j < n; j++) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }

            sb.append(function(deque, cmd).replace(" ", "")).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static String function(Deque<Integer> deque, String cmd) {
        boolean direction = true; // true : 정방향(peek = 앞), false : 역방향(peek = 뒤)

        for (int j = 0; j < cmd.length(); j++) {
            switch (cmd.charAt(j)) {
                case 'R':
                    direction = !direction;
                    break;
                case 'D':
                    if (deque.isEmpty()) {
                        return "error";
                    }

                    if (direction) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                    break;
            }
        }

        int[] arr = new int[deque.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = direction ? deque.pollFirst() : deque.pollLast();
        }

        return Arrays.toString(arr);
    }
}
