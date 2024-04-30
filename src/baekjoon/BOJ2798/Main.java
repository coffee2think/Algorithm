package src.baekjoon.BOJ2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * date: 2024-04-30
 * source: https://www.acmicpc.net/problem/2798
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        // when
        int maxSum = 0;

        loop:
        for(int i = 0; i < N - 2; i++){
            int sum = cards[i];
            if (sum > M) break; // 오름차순 정렬되어 이후의 값들은 더 커질 수밖에 없으므로 break

            for(int j = i + 1; j < N - 1; j++){
                sum = cards[i] + cards[j];
                if (sum > M) break; // 오름차순 정렬되어 이후의 값들은 더 커질 수밖에 없으므로 break

                int thirdIndex = findMaxIndex(cards, M, sum, j + 1);
                try {
                    sum += cards[thirdIndex];
                    if (sum == M) {
                        maxSum = sum;
                        break loop;
                    }

                    maxSum = Math.max(maxSum, sum);
                } catch (Exception e) {
                    // thirdIndex가 -1인 경우 ArrayIndexOutOfBoundsException 발생
                    break;
                }
            }
        }

        // then
        System.out.println(maxSum);
        br.close();
    }

    // 이진 탐색을 이용하여 합이 M 이하인 최댓값을 찾는다.
    public static int findMaxIndex(int[] cards, int M, int sum, int start) {
        int end = cards.length - 1;
        int maxIndex = -1; // 합이 M 이하인 최댓값의 인덱스. 없으면 -1

        while (start <= end) {
            int mid = (start + end) / 2;
            if (sum + cards[mid] <= M) {
                maxIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return maxIndex;
    }
}
