package programmers.correctParentheses;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        //방법1. 스택을 이용하지 않는 방법
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else cnt--;

            if (cnt < 0) return false;
        }

        if (cnt == 0) return true;
        else return false;


        //방법2. 스택을 이용한 방법
//        Stack<Character> stack = new Stack<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (stack.isEmpty()) {
//                    return false;
//                } else if (stack.peek() == '(') {
//                    stack.pop();
//                }
//            } else {
//                stack.push(s.charAt(i));
//            }
//        }
//
//        if (stack.isEmpty()) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
