package algorithm.theory.knapsackproblem;

import java.util.Arrays;

public class Backtracking {
    static int n; // 아이템의 개수
    static int W; // 최대 무게
    static int[] p; // 아이템의 가치
    static int[] w; // 아이템의 무게
    static boolean[] include; // 포함여부(방문여부)를 저장할 배열
    static int maxprofit = 0, numbest = 0; // 최대이익과 position을 저장할 변수
    static boolean[] bestset; // best 상태를 저장할 배열


    public static void main(String[] args) {
        n = 4;
        W = 16;
        p = new int[]{0, 40, 30, 50, 10};
        w = new int[]{0, 2, 5, 10, 5};

        include = new boolean[n + 1];
        bestset = new boolean[n + 1];

        knapsack3(0, 0, 0);
        System.out.println(Arrays.toString(bestset));

        int bestProfit = 0;
        for(int i = 1; i < bestset.length; i++){
            if(bestset[i]) bestProfit += p[i];
        }
        System.out.println(bestProfit);
    }

    public static void knapsack3(int i, int profit, int weight) {
        if (weight < W && profit > maxprofit) {
            maxprofit = profit;
            numbest = i;
            for (int j = 1; j < include.length; j++) {
                bestset[j] = include[j];
            }
        }

        if (promising(i, profit, weight)) {
            include[i + 1] = true;
            knapsack3(i + 1, profit + p[i + 1], weight + w[i + 1]);
            include[i + 1] = false;
            knapsack3(i + 1, profit, weight);
        }
    }

    public static boolean promising(int i, int profit, int weight) {
        if(weight > W) return false;
        else {
            int j = i + 1;
            int bound = profit;
            int totweight = weight;

            while(j <= n && totweight + w[j] <= W) {
                totweight += w[j];
                bound += p[j];
                j++;
            }

            int k = j;
            if(k <= n){
                bound += (W - totweight) * p[k] / w[k];
            }

            return bound > maxprofit;
        }
    }
}
