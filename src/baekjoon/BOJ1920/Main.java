package src.baekjoon.BOJ1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * date: 2024-05-13
 * source: https://www.acmicpc.net/problem/1920
 */

// Map을 이용한 방식
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>(); // Entry = {number : index}
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(st.nextToken()), i);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 검색 수행
        while(M-- > 0) {
            if (map.containsKey(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
        br.close();
    }
}
