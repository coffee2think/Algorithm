package src.programmers.lv2.Q42839;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * date: 2024-05-09
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */

public class Main {
    private static int[] pow10;
    private static Set<Integer> primeSet;

    public static void main(String[] args) {
        // given
        String[] numbers = {"17", "011"};
        int[] answer = {3, 2};

        // when
        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Main().solution(numbers[i]);
        }

        // then
        System.out.println("result: " + Arrays.toString(result) + " is " + ((Arrays.equals(result, answer) ? "Correct!" : "Wrong..")));
    }

    public int solution(String numbers) {
        powInit(numbers.length());
        primeSet = new HashSet<>();

        int[] numArray = new int[numbers.length()];
        boolean[] visited = new boolean[numArray.length];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = numbers.charAt(i) - '0';
        }

        for (int i = 0; i < numArray.length; i++){
            visited[i] = true;
            dfs(0, numArray[i], numArray, visited);
            visited[i] = false;
        }

        return primeSet.size();
    }

    public void dfs(int depth, int union, int[] numArray, boolean[] visited) {
        // union이 소수라면 Set에 추가
        if (isPrime(union)) {
            primeSet.add(union);
        }

        // 마지막 깊이라면 dfs 종료
        if (depth == numArray.length - 1) {
            return;
        }

        // 다음 과정 진행
        for (int i = 0; i < numArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, union + numArray[i] * pow10[depth + 1], numArray, visited);
                visited[i] = false;
            }
        }
    }

    // 소수 판별 메소드
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 10의 거듭제곱 배열 초기화
    public void powInit(int size) {
        pow10 = new int[size + 1];
        pow10[0] = 1;
        for (int i = 1; i < pow10.length; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
    }
}
