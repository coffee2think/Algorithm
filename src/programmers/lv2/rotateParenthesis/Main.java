package programmers.lv2.rotateParenthesis;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + s.substring(0, 1);
            System.out.print("s : " + s + " -> ");
            if (isCorrect(s)) {
                System.out.println("Correct");
                cnt++;
            } else {
                System.out.println("Incorrect");
            }
        }

        return cnt;
    }

    public static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);

            if (input == '(' || input == '{' || input == '[') {
                stack.push(input);
            } else if (!stack.isEmpty() && ((input == ')' && stack.peek() == '(')
                    || (input == '}' && stack.peek() == '{') || (input == ']' && stack.peek() == '['))) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
