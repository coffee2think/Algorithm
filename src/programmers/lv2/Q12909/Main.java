package src.programmers.lv2.Q12909;

import java.util.Stack;

/**
 * beginning date: 2025-10-09
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */

public class Main {
    public static void main(String[] args) {
        String[] s = {
                "()()",
                "(())()",
                ")()(",
                "(()("
        };
        boolean[] answer = {
                true,
                true,
                false,
                false
        };

        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (solution2(s[i]) == answer[i]) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2025-10-09
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                // c == ')' && stack is Empty
                return false;
            } else {
                // c == ')' && (stack is not Empty => stack.peek() == '(')
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // solved date: 2025-10-09
    public static boolean solution2(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else cnt--;

            if (cnt < 0) return false;
        }

        return cnt == 0;
    }
}
