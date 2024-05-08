package src.programmers.lv2.Q42746;

import java.util.Arrays;

/**
 * date: 2024-05-07
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */

public class Main {
    private int[] pow10;

    public static void main(String[] args) {
        // given
        int[][] numbers = {
                {6, 10, 2},
                {30, 3, 34, 5, 9},
                {979, 97, 978, 81, 818, 817},
                {0, 0, 0, 0, 0}
        };

        String[] answer = {
                "6210",
                "9534330",
                "9799797881881817",
                "0"
        };

        // when
        String[] result = new String[answer.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Main().solution(numbers[i]);
        }

        // then
        for (int i = 0; i < result.length; i++) {
            System.out.println("result: " + result[i] + " is " + ((result[i].equals(answer[i])) ? "Correct!" : "Wrong.."));
        }
    }

    // Integer 배열 정렬하기
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        powInit(4);

        // Arrays.sort()를 사용하기 위한 박싱
        Integer[] boxingNumbers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            boxingNumbers[i] = numbers[i];
        }

        // 배열 정렬
        Arrays.sort(boxingNumbers, (n1, n2) -> {
            int case1 = numConcat(n1, n2); // "n1" + "n2"
            int case2 = numConcat(n2, n1); // "n2" + "n1"

            return case2 - case1;
        });

        // 모든 수가 0이라면 0을 리턴
        if (boxingNumbers[0] == 0) {
            return "0";
        }

        // 정렬된 배열을 문자열로 담음
        for (int n : boxingNumbers) {
            sb.append(n);
        }

        return sb.toString();
    }

    public int numConcat(int n1, int n2) {
        int digit2 = (n2 == 0) ? 0 : (int)Math.log10(n2);
        return n1 * pow10[digit2 + 1] + n2;
    }

    public void powInit(int size) {
        pow10 = new int[size + 1];
        pow10[0] = 1;
        for (int i = 1; i < pow10.length; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
    }
}
