package src.baekjoon.BOJ9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * date: 2024-05-29
 * source: https://www.acmicpc.net/problem/9935
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        String str = br.readLine();
        String compareStr = br.readLine();

        // solution
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        int strIndex = 0;
        while (strIndex < str.length()){
            stack.push(str.charAt(strIndex++));

            int compareIndex = compareStr.length() - 1;
            while (!stack.isEmpty() && stack.peek() == compareStr.charAt(compareIndex)) {
                temp.push(stack.pop());
                compareIndex--;

                if (compareIndex < 0) {
                    temp.clear();
                    break;
                }
            }

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        // print result
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
        br.close();
    }
}
