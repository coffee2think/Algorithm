package src.programmers.lv2.Q154539;

import java.util.Arrays;
import java.util.Stack;

/**
 * Programmers Q154539 lv2
 * Problem name: 뒤에 있는 큰 수 찾기
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 3, 5};
        int[] result = new int[]{3, 5, 5, -1};

        System.out.println(new Main().solution(numbers));
        System.out.println(Arrays.equals(new Main().solution(numbers), result));
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
