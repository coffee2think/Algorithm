package algorithm.theory.knapsackproblem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BranchAndBound {
    static int n; // 아이템의 개수
    static int W; // 최대 무게

    public static void main(String[] args) {
        n = 4;
        W = 16;
        int[] p = new int[]{0, 40, 30, 50, 10}; // 아이템의 가치(이익) profit
        int[] w = new int[]{0, 2, 5, 10, 5}; // 아이템의 무게 weight

        int maxprofit = knapsack4(p, w, W);
        System.out.println(maxprofit);

    }

    public static int knapsack4(int[] p, int[] w, int W) {
        PriorityQueue<SSTNode> PQ = new PriorityQueue<>();
        SSTNode v = new SSTNode(0, 0, 0);
        int maxprofit = 0;

        v.bound = bound(v, p, w);
        PQ.add(v);
        while(!PQ.isEmpty()){
            v = PQ.poll();
            if(v.bound > maxprofit){
                int level = v.level + 1;
                int profit = v.profit + p[level];
                int weight = v.weight + w[level];
                SSTNode u = new SSTNode(level, profit, weight);
                if(u.weight <= W && u.profit > maxprofit) {
                    maxprofit = u.profit;
                }
                u.bound = bound(u, p, w);
                if(u.bound > maxprofit){
                    PQ.add(u);
                }
                u = new SSTNode(level, v.profit, v.weight);
                u.bound = bound(u, p, w);
                if(u.bound > maxprofit){
                    PQ.add(u);
                }
            }
        }

        return maxprofit;
    }

    public static int bound(SSTNode u, int[] p, int[] w){
        int n = p.length - 1;
        if(u.weight >= W){
            return 0;
        } else {
            int result = u.profit;
            int j = u.level + 1;
            int totweight = u.weight;

            while(j <= n && totweight + w[j] <= W){
                totweight += w[j];
                result += p[j];
                j++;
            }

            int k = j;
            if (k <= n){
                result += (W - totweight) * p[k] / w[k];
            }

            return result;
        }
    }
}

class SSTNode implements Comparable<SSTNode> {
    int level;
    int profit;
    int weight;
    int bound;

    public SSTNode(int level, int profit, int weight) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
        this.bound = 0;
    }

    @Override
    public int compareTo(SSTNode target) {
        return target.bound - this.bound;
    }

    public void print() {
        System.out.println(level + ", " + profit + ", " + weight + ", " + bound);
    }
}