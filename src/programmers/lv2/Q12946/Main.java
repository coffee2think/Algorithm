package src.programmers.lv2.Q12946;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * date: 2024-04-30
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // given
        int n = 2;
        int[][] answer = {
            {1, 2},
            {1, 3},
            {2, 3}
        };

        // when
        int[][] result = new Main().solution(n);

        // then
        System.out.println("result: " + Arrays.deepToString(result) + " is " + (Arrays.deepEquals(result, answer) ? "Correct!" : "Wrong.." ));
    }

    public int[][] solution(int n) {
        List<Integer[]> processList = new ArrayList<>();

        hanoi(processList, n, 1, 3);

        // List를 int[][]로 변환
        int[][] process = new int[processList.size()][2];
        for (int i = 0; i < processList.size(); i++) {
            process[i] = new int[]{processList.get(i)[0], processList.get(i)[1]};
        }

        return process;
    }

    public void hanoi(List<Integer[]> processList, int n, int from, int to) {
        if (n == 1) {
            processList.add(new Integer[]{from, to});
            return;
        }

        int via = 6 - from - to;
        hanoi(processList, n - 1, from, via);
        processList.add(new Integer[]{from, to});
        hanoi(processList, n - 1, via, to);
    }
}