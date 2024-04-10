package src.programmers.lv2.Q134239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Programmers Q134239 lv2
 * Problem name: 우박수열 정적분
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/134239
 */

public class Main {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {
            {0, 0},
            {0, -1},
            {2, -3},
            {3, -3}
        };

        System.out.println(Arrays.toString(new Main().solution(k, ranges)));
    }

    public double[] solution(int k, int[][] ranges) {
        List<Integer> seq = new ArrayList<>(); // 수열을 저장할 리스트
        seq.add(k); // 초기항

        // 콜라츠 수열 생성
        while(seq.get(seq.size() - 1) > 1) {
            int last = seq.get(seq.size() - 1);
            int collatz = last % 2 == 0 ? last / 2 : last * 3 + 1;
            seq.add(collatz);
        }

        // 정적분 결과 저장
        double[] result = new double[ranges.length];
        for (int i = 0; i < result.length; i++) {
            int start = ranges[i][0];
            int end = seq.size() - 1 + ranges[i][1];
            result[i] = integral(start, end, seq);
        }

        return result;
    }

    // 주어진 구간에 대해 정적분
    public double integral(int start, int end, List<Integer> seq) {
        // 구간이 잘못되었을 경우
        if (start > end) {
            return -1.0;
        }

        double sum = 0;

        for (int i = start; i < end; i++) {
            sum += (double) (seq.get(i) + seq.get(i + 1)) / 2.0;
        }

        return sum;
    }
}
