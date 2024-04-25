package src.programmers.lv2.Q132265;

import java.util.HashSet;
import java.util.Set;

/**
 * date: 2024-04-25
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */

public class Main {
    public static void main(String[] args) {
        // given
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = 2;

        // when
        int result = new Main().solution(topping);

        // then
        System.out.println("result: " + result + " is " + (result == answer ? "Correct!" : "Wrong.."));
    }

    public int solution(int[] topping) {
        int answer = 0;

        int[] left = new int[topping.length];
        int[] right = new int[topping.length];
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();

        leftSet.add(topping[0]);
        rightSet.add(topping[topping.length - 1]);
        left[0] = right[0] = 1;
        for (int i = 1; i < topping.length; i++) {
            leftSet.add(topping[i]);
            rightSet.add(topping[topping.length - 1 - i]);
            left[i] = leftSet.size();
            right[right.length - 1 - i] = rightSet.size();
        }

        for (int i = 0; i < topping.length - 1; i++) {
            if (left[i] == right[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}
