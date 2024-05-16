package src.baekjoon.BOJ12015;

import java.io.*;
import java.util.*;

/**
 * date: 2024-05-16
 * source: https://www.acmicpc.net/problem/12015
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < seq.length; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // when
        List<Integer> lis = new ArrayList<>();
        for (int num : seq) {
            // 현재 숫자가 lis의 최댓값보다 크면 lis에 추가
            // 그렇지 않다면 현재 숫자보다 큰 숫자 중 가장 작은 값을 찾아 교체
            if (lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                lis.set(findFirstBiggerNumber(lis, num), num);
            }
        }

        // then
        System.out.println(lis.size());
        br.close();
    }

    public static int findFirstBiggerNumber(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size() - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if (lis.get(mid) >= num) { // 숫자가 이미 존재하는 경우 그대로 유지 하기 위해 조건에 포함시킴
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
