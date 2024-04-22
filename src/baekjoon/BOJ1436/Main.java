package src.baekjoon.BOJ1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon Q1436 실버5
 * Problem name: 영화감독 숌
 * link: https://www.acmicpc.net/problem/1436
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 666; i < Integer.MAX_VALUE; i++){
            String str = String.valueOf(i);
            if(str.contains("666") && ++cnt == N){
                System.out.println(str);
                break;
            }
        }

        br.close();
    }
}
