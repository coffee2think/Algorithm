package baekjoon.BOJ7120;

import src.PerformanceTester;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// link: https://www.acmicpc.net/problem/7120
// date: 2025-10-14
public class Main {
    public static void main(String[] args) throws Exception {
        PerformanceTester.measure(new Main()::solve);
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        char head = str.charAt(0);
        sb.append(head);
//        for (int i = 1; i < str.length(); i++) {
//            if (str.charAt(i) != head) {
//                head = str.charAt(i);
//                sb.append(head);
//            }
//        }
        System.out.println(sb);
        br.close();
    }
}
