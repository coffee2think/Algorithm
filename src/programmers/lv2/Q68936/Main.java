package src.programmers.lv2.Q68936;

import java.util.Arrays;

/**
 * date: 2024-05-09
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */

public class Main {
    public static void main(String[] args) {
        // given
        int[][][] arr = {
                {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}},
                {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}}
        };
        int[][] answer = {
                {4, 9},
                {10, 15}
        };

        // when
        int[][] result = new int[answer.length][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Main().solution(arr[i]);
        }

        // then
        System.out.println("result: " + Arrays.deepToString(result) + " is " + (Arrays.deepEquals(result, answer) ? "Correct!" : "Wrong.."));
    }

    public int[] solution(int[][] arr) {
        return divide(arr, 0, 0, arr.length);
    }

    // 영역 분할
    public int[] divide(int[][] arr, int x, int y, int size) {
        if (size == 1) {
            // 0이면 {1, 0}, 1이면 {0, 1} 반환
            return new int[]{1 - arr[y][x], arr[y][x]};
        }

        int[] count = new int[2];

        int value = check(arr, x, y, size);
        if (value != -1) {
            count[value]++;
        } else {
            int newSize = size / 2;
            count = combine(count, divide(arr, x, y, newSize));
            count = combine(count, divide(arr, x + newSize, y, newSize));
            count = combine(count, divide(arr, x, y + newSize, newSize));
            count = combine(count, divide(arr, x + newSize, y + newSize, newSize));
        }

        return count;
    }

    // 배열 합치기
    public int[] combine(int[] a, int[] b) {
        int[] rtn = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            rtn[i] = a[i] + b[i];
        }
        return rtn;
    }

    // 영역 안의 숫자가 모두 같은지 확인
    public int check(int[][] arr, int x, int y, int size) {
        int value = arr[y][x];
        for (int j = y; j < y + size; j++) {
            for (int i = x; i < x + size; i++) {
                if (arr[j][i] != value) {
                    return -1;
                }
            }
        }
        return value;
    }
}
