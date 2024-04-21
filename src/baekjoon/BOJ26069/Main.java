package src.baekjoon.BOJ26069;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> dancers = new HashSet<>();
        dancers.add("ChongChong");

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();

            if (dancers.contains(person1) || dancers.contains(person2)) {
                dancers.add(person1);
                dancers.add(person2);
            }
        }
        System.out.println(dancers.size());
        br.close();
    }
}