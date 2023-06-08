package AlgorithmTest.Baekjoon.BOJ1874;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        for (int i = 0; i < n; ++i)
            sequence[i] = Integer.parseInt(br.readLine());

        System.out.println(solution(sequence));
        br.close();
    }

    public static String solution(int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < sequence.length; ++i) {
            if(stack.isEmpty()) {
                stack.push(++cnt);
                sb.append("+\n");
            }

            while (stack.peek() != sequence[i]) {
                if (stack.peek() > sequence[i]) {
                    return "NO";
                } else {
                    stack.push(++cnt);
                    sb.append("+\n");
                }
            }
            stack.pop();
            sb.append("-\n");
        }

        return sb.toString();
    }
}
