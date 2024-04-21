package src.baekjoon.BOJ17504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Baekjoon Q17504 실버5
 * Problem name: 제리와 톰 2
 * link: https://www.acmicpc.net/problem/17504
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[] answer = new long[2];
        Stack<Integer> stack = new Stack<>();

        // given
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        // when
        answer[0] = 0;
        answer[1] = 1;
        while (!stack.isEmpty()) {
            long[] sum = sumFractions(new long[]{stack.pop(), 1}, answer);

            // 역수를 취함
            answer[0] = sum[1];
            answer[1] = sum[0];
        }
        // 1 - 연분수
        answer = reduceFraction(answer[1] - answer[0], answer[1]);

        // then
        System.out.println(answer[0] + " " + answer[1]);
        br.close();
    }

    // 분수를 더하고 기약분수를 리턴
    public static long[] sumFractions(long[] p, long[] q) {
        long newNum = p[0] * q[1] + p[1] * q[0];
        long newDiv = p[1] * q[1];
        return reduceFraction(newNum, newDiv);
    }

    // 기약분수 구하기
    public static long[] reduceFraction(long num, long div) {
        long gcd = gcd(num, div);
        return new long[]{num / gcd, div / gcd};
    }

    // 최대 공약수
    public static long gcd(long n, long r) {
        if (r == 0) return n;
        return gcd(r, n % r);
    }
}
