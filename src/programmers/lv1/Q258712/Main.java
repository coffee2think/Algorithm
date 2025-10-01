package src.programmers.lv1.Q258712;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * date: 2025-10-01
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/258712?language=java
 */


public class Main {
    public static void main(String[] args) {
        String[] friends = { "muzi", "ryan", "frodo", "neo" };
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        int answer = 2;

        if (solution(friends, gifts) == answer) {
            System.out.println("정답입니다.");
        } else {
            System.out.println("틀렸습니다.");
        }
    }

    public static int solution(String[] friends, String[] gifts) {
        StringTokenizer st = null;

        int n = friends.length;
        int[][] giftTrade = new int[n + 1][n + 1];
        Map<String, Integer> friendsIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendsIndex.put(friends[i], i);
        }

        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            int giverIndex = friendsIndex.get(st.nextToken());
            int takerIndex = friendsIndex.get(st.nextToken());;

            giftTrade[giverIndex][takerIndex]++; // giftTrade[A][B] : A가 B에게 선물 준 횟수 or B가 A에게 선물 받은 횟수
            giftTrade[giverIndex][n]++; // giftTrade[A][n] : A가 선물을 준 총 횟수
            giftTrade[n][takerIndex]++; // giftTrade[n][B] : B가 선물을 받은 총 횟수
        }

        int[] point = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int iGiveJ = giftTrade[i][j];
                int jGiveI = giftTrade[j][i];
                int iGiftIndex = giftTrade[i][n] - giftTrade[n][i];
                int jGiftIndex = giftTrade[j][n] - giftTrade[n][j];

                if (iGiveJ > jGiveI) point[i]++;
                else if (iGiveJ < jGiveI) point[j]++;
                else if (iGiftIndex > jGiftIndex) point[i]++;
                else if (iGiftIndex < jGiftIndex) point[j]++;
            }
        }

        int maxPoint = point[0];
        for (int i = 1; i < n; i++) {
            if (point[i] > maxPoint) maxPoint = point[i];
        }

        return maxPoint;
    }
}
