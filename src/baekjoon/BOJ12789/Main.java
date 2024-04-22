package src.baekjoon.BOJ12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Baekjoon Q12789 실버3
 * Problem name: 도키도키 간식드리미
 * link: https://www.acmicpc.net/problem/12789
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // when
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        while(st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());

            // 스택의 상단에 입력값보다 작은 값이 남아있으면 다음에 꺼낼 수 없으므로 반복문 종료
            if (!stack.isEmpty() && input > stack.peek()) {
                break;
            }

            stack.push(input);
            while (!stack.isEmpty() && stack.peek() == idx) {
                stack.pop();
                idx++;
            }
        }

        // then
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
        br.close();
    }
}
