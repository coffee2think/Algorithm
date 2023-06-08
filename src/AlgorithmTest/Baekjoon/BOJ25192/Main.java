package AlgorithmTest.Baekjoon.BOJ25192;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> users = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                users.clear();
            } else if (!users.contains(input)) {
                users.add(input);
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}