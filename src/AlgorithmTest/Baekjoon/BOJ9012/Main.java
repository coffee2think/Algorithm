package AlgorithmTest.Baekjoon.BOJ9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; ++i) {
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean VPS = true;

            for (int j = 0; j < str.length(); ++j) {
                char ch = str.charAt(j);
                if (ch == ')') {
                    if (stack.isEmpty()) {
                        VPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (ch == '(') {
                    stack.push('(');
                }
            }

            if (!stack.isEmpty())
                VPS = false;

            if (VPS)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
