package src.baekjoon.BOJ2110;

import java.io.*;
import java.util.*;

/**
 * date: 2024-05-15
 * source: https://www.acmicpc.net/problem/2110
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        // when
        Arrays.sort(house); // 이진탐색을 하기 위해 오름차순 정렬

        int answer = -1;
        int left = 1;
        int right = house[house.length - 1] - house[0];

        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int installed = house[0];

            for (int i = 1; i < house.length; i++) {
                if (house[i] - installed >= mid) { // mid 거리마다 공유기 설치
                    installed = house[i];
                    count++;
                }
            }

            if (count >= C) { // C개로 설치가능하면 거리를 늘림
                answer = mid;
                left = mid + 1;
            } else { // C개로 설치 불가능하면 거리를 좁힘
                right = mid - 1;
            }
        }

        // then
        System.out.println(answer);
        br.close();
    }
}
