package baekjoon.BOJ1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/1092
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크레인의 무게 제한 배열 초기화
        int N = Integer.parseInt(br.readLine());
        int[] cranes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cranes.length; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(cranes);

        // 크레인별로 수용 가능한 박스 개수 담기
        int M = Integer.parseInt(br.readLine());
        int[] tasks = new int[M];

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tasks.length; i++) {
            int box = Integer.parseInt(st.nextToken());

            while (box > cranes[idx]) {
                idx++;
            }

            cranes[idx]++;
        }

        // when


        // then
        System.out.println();
        br.close();
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
