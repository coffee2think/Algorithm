package src.baekjoon.BOJ11723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/11723
// date: 2025-11-04
// 참신한 풀이(비트연산 활용) : https://www.acmicpc.net/source/99912618
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                case "all":
                    for (int i = 1; i <= 20; i++) {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
