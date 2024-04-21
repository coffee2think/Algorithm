package src.baekjoon.BOJ4949;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("."))
                break;
            else
                System.out.println(solution(str));
        }

        br.close();
    }

    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }

        if (stack.isEmpty())
            return "yes";
        else
            return "no";
    }
}