package algorithm.theory.knapsackproblem;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {
    public static void main(String[] args) {
        int maxWeight = 30;
        int[] weight = {0, 5, 10, 20};
        int[] profit = {0, 50, 60, 140};

        int maxProfit = knapsack2(weight.length - 1, maxWeight, weight, profit);
        System.out.println(maxProfit);
    }

    public static int knapsack2(int i, int maxWeight, int[] weight, int[] profit) {
        if (i <= 0 || maxWeight <= 0) { // 아이템이 없거나 배낭의 무게가 없으면
            return 0;
        } else if (weight[i] > maxWeight) { // 아이템의 무게가 배낭의 무게보다 크면
            return knapsack2(i - 1, maxWeight, weight, profit);
        } else { // weight[i] <= maxWeight
            int left = knapsack2(i - 1, maxWeight, weight, profit);
            int right = knapsack2(i - 1, maxWeight - weight[i], weight, profit);

            return Math.max(left, profit[i] + right);
        }
    }
}
