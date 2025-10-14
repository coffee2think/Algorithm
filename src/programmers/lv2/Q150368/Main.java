package src.programmers.lv2.Q150368;

import java.util.Objects;

// link: https://school.programmers.co.kr/learn/courses/30/lessons/150368?language=java
// date: 2025-10-10
public class Main {
    public static void main(String[] args) {
        // given
        int[][][] users = {
                {{40, 10000}, {25, 10000}},
                {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}
        };
        int[][] emoticons = {
                {7000, 9000},
                {1300, 1500, 1600, 4900}
        };
        int[][] answer = {
                {1, 5400},
                {4, 13860}
        };

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Objects.deepEquals(solution(users[i], emoticons[i]), answer[i])) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        // then
        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2025-10-10
    private static int maxPlusMembers = 0;
    private static int maxSales = 0;
    private static final int[] RATES = {10, 20, 30, 40};

    public static int[] solution(int[][] users, int[] emoticons) {
        maxPlusMembers = 0;
        maxSales = 0;

        dfs(0, new int[emoticons.length], users, emoticons);

        return new int[]{maxPlusMembers, maxSales};
    }

    public static void dfs(int emoticonIndex, int[] discounts, int[][] users, int[] emoticons) {
        if (emoticonIndex == discounts.length) {
            int plusMembers = 0;
            int totalSales = 0;
            for (int[] user : users) {
                int userPrice = 0;
                int requiredDiscount = user[0];
                int maxCost = user[1];

                for (int i = 0; i < discounts.length; i++) {
                    if (discounts[i] >= requiredDiscount) {
                        userPrice += emoticons[i] * (100 - discounts[i]) / 100;
                    }
                }

                if (userPrice >= maxCost) {
                    plusMembers++;
                } else {
                    totalSales += userPrice;
                }
            }

            if (plusMembers > maxPlusMembers) {
                maxPlusMembers = plusMembers;
                maxSales = totalSales;
            } else if (plusMembers == maxPlusMembers && totalSales > maxSales) {
                maxSales = totalSales;
            }

            return;
        }

        for (int rate : RATES) {
            discounts[emoticonIndex] = rate;
            dfs(emoticonIndex + 1, discounts, users, emoticons);
        }
    }
}
