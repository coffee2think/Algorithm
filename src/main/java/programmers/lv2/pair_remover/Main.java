package programmers.lv2.pair_remover;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || (stack.peek() != s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }
}
