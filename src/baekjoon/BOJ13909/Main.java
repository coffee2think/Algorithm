package src.baekjoon.BOJ13909;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 창문은 약수의 개수만큼 열리고 닫힘
        // 약수의 개수가 홀수면 열림, 짝수면 닫힘
        // 약수의 개수가 홀수인 경우는 n의 제곱근이 자연수인 경우뿐 = n은 제곱수 = 제곱수의 개수를 구하라
        int cnt = 0;
        for (int i = 1; i * i <= N; i++) {
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}