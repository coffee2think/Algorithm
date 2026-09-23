package programmers.lv3.Q132266;

/**
 * Programmers 132266 lv3
 * Problem name: 부대복귀
 * link: https://programmers.co.kr/learn/courses/30/lessons/132266
 */

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] roads = new int[][]{
                {1, 2},
                {2, 3}
        };
        int[] sources = new int[]{2, 3};
        int destination = 1;

        int[] result = new int[]{1, 2};

        System.out.println(solution(n, roads, sources, destination) == result);
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};

        return answer;
    }
}
