package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) throws IOException {
        // given
        int n = 12;

        // solution
        int[] answer = {};
        List<Integer> factors = new ArrayList<>();

        // 1. 2 이상의 소수들을 반복하여 나눈다.
        // 1-1. 2 이상 n 이하의 소수를 찾는다.
        // 1-2. 2를 factors에 넣는다
        // 1-3. n' 은 더이상 2로 나눌 수 없는 수
        // 1-4. 2보다 크고, n' 이하의 소수를 찾는다
        // 1-5. 1-2를 반복한다.

        // answer

    }

    public static int findMinimalFactor(int n, int start) throws Exception {
        if (n <= start) {
            throw new ArithmeticException("");
        }

        return 0;
    }
}