package programmers.lv2.cutarray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int left = 7;
        int right = 14;

        System.out.println(Arrays.toString(solution(n, left, right)));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (int i = 0; i < answer.length; i++) {
            int row = (int) ((left + i) / n) + 1;
            int col = (int) ((left + i) % n) + 1;
            answer[i] = Math.max(row, col);
        }

        return answer;
    }
}
