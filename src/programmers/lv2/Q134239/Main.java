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
        List<Double> psum = new ArrayList<>(); // 누적합을 저장할 리스트
        int collatz = k; // 초기항은 k

        psum.add((double) collatz);

        // 콜라츠 수열에 대한 누적합 리스트 생성
        while(collatz != 1) {
            int old = collatz;
            collatz = collatz % 2 == 0 ? collatz / 2 : collatz * 3 + 1;
            psum.add(psum.get(psum.size() - 1) + (old + collatz) / 2.0);
        }

        // 정적분 결과 저장
        double[] result = new double[ranges.length];
        for (int i = 0; i < result.length; i++) {
            int start = ranges[i][0];
            int end = psum.size() - 1 + ranges[i][1];
            result[i] = (start <= end) ? psum.get(end) - psum.get(start) : -1;
        }

        return result;
    }
}
