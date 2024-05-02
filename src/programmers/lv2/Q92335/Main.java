package src.programmers.lv2.Q92335;

import java.util.StringTokenizer;

/**
 * date: 2024-05-02
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */

public class Main {
    public static void main(String[] args) {
        // given
        int n = 437674;
        int k = 3;
        int answer = 3;

        // when
        int result = new Main().solution(n, k);

        // then
        System.out.println("result: " + result + " is " + (result == answer ? "Correct!" : "Wrong.."));
    }

    public int solution(int n, int k) {
        int count = 0;

        StringTokenizer st = new StringTokenizer(Long.toString(n, k), "0"); // k진법 변환 후 0을 기준으로 분리
        while(st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            count += isPrime(num) ? 1 : 0;
        }

        return count;
    }

    public boolean isPrime(long n) {
        if (n < 2) return false;

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
