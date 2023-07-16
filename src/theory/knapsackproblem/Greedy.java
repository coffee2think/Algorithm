package algorithm.theory.knapsackproblem;

import java.util.Arrays;

public class Greedy {
    public static void main(String[] args) {
        int totalWeight = 30;
        int[] weight = {2, 5, 8, 7, 40, 13, 24};
        int[] value = {15, 12, 8, 8, 7, 5, 2};

        int[] knapsack = knapsack1(totalWeight, weight, value);
        System.out.println(Arrays.toString(knapsack));
    }

    public static int[] knapsack1(int totalWeight, int[] weight, int[] value) {
        int[] knapsack = new int[weight.length];

        int accWeight = 0;
        for (int i = 0; i < weight.length; i++) {
            accWeight += weight[i];
            knapsack[i] = weight[i];
            if(accWeight > totalWeight){
                knapsack[i] -= (accWeight - totalWeight);
                break;
            }
        }

        return knapsack;
    }
}
