package src.baekjoon.BOJ9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon Q9465 실버1
 * Problem name: 스티커
 * link: https://www.acmicpc.net/problem/9465
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    stickers[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n];

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            if (n > 1) {
                dp[0][1] = dp[1][0] + stickers[0][1];
                dp[1][1] = dp[0][0] + stickers[1][1];
            }

            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}

/**
 * 신창혁님 풀이
 * 두 변을 공유하지 않는 스티커 접수의 최댓값 출력하기
 */

//public class 스티커_9465_240424 {
//
//    static int T;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//
//        T = Integer.parseInt(br.readLine());
//
//        // 게임 진행
//        while (T-- > 0) {
//            int n = Integer.parseInt(br.readLine());
//            int[][] sticker = new int[2][n]; // 스터커 배열 정의
//            int[][] dp = new int[2][n];
//
//            for (int i = 0; i < 2; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < n; j++) {
//                    sticker[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            sb.append(pro(sticker, dp, n) + "\n");
//        }
//
//        // 결과 출력
//        System.out.println(sb.toString());
//    }
//
//    private static int pro(int[][] sticker, int[][] dp, int n) {
//        // 초기 값 설정
//        dp[0][0] = sticker[0][0];
//        dp[1][0] = sticker[1][0];
//        // dp 진행
//        for (int i = 1; i < n; i++) {
//            if (i == 1) { // 1 <= n <= 100,000
//                dp[0][1] = dp[1][0] + sticker[0][1];
//                dp[1][1] = dp[0][0] + sticker[1][1];
//                continue;
//            }
//            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
//            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
//        }
//        return Math.max(dp[0][n - 1], dp[1][n - 1]);
//    }
//}

// 파이썬 A팀 코드
//'''
//dynamic programming 을 사용
//j를 0부터 n-1까지 가면서 point[0][j]와 point[1][j]를 수정
//point[i][j]는 sticker[i][j]를 사용한 경우의 현재 합의 최댓값을 의미
//'''
//import sys
//
//t = int(sys.stdin.readline())
//
//for _ in range(t):
//n = int(sys.stdin.readline())
//stickers = []
//for i in range(2):
//stickers.append(list(map(int, sys.stdin.readline().split())))
//
//if n == 1:
//print(max(stickers[0][0], stickers[1][0]))
//continue
//
//point = [[0] * n, [0] * n] # point[i][j] = stickers[i][j] 를 사용했을 때 점수 합의 최댓값
//point[0][0] = stickers[0][0]
//point[1][0] = stickers[1][0]
//point[0][1] = stickers[1][0] + stickers[0][1]
//point[1][1] = stickers[0][0] + stickers[1][1]
//
//for i in range(2, n):
//point[0][i] = max(point[1][i - 2], point[1][i - 1]) + stickers[0][i]
//point[1][i] = max(point[0][i - 2], point[0][i - 1]) + stickers[1][i]
//
//print(max(point[0][-1], point[1][-1]))

// 파이썬 B팀 코드
//import sys
//input = sys.stdin.readline
//
//if __name__ == "__main__":
//T = int(input())
//
//for test_case in range(T):
//
//dp = []
//n = int(input())
//
//for i in range(2):
//dp.append(list(map(int, input().split()))) # dp[0]은 첫 번째 줄
//
//if n != 1: # 1 인경우는 바로 출력
//
//dp[0][1] += dp[1][0]
//dp[1][1] += dp[0][0] # 두 번째까지 미리 계산
//
//for i in range(2, n): # 세 번째 부터 시작
//
//dp[0][i] += max(dp[1][i-1], dp[1][i-2]) # 이웃하지 않은 대각선이거나, 그 옆
//dp[1][i] += max(dp[0][i-1], dp[0][i-2]) # 마찬가지
//
//print(max(dp[0][n-1], dp[1][n-1]))

// 파이썬 멘토님 코드
//def input_data():
//n = int(input())
//points = [list(map(int, input().split())) for _ in range(2)]
//return n, points
//
//
//def solution():
//n, points = input_data()
//for y in range(1, n):
//for x in range(2):
//points[x][y] = max(
//points[x][y - 1], points[(x + 1) % 2][y - 1] + points[x][y]
//)
//return max(points[0][n - 1], points[1][n - 1])
//
//
//if __name__ == "__main__":
//T = int(input())
//for _ in range(T):
//print(solution())