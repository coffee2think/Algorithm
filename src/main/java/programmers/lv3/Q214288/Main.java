package programmers.lv3.Q214288;

/**
 * Programmers 214288 lv3
 * Problem name: 상담원 인원
 * link: https://programmers.co.kr/learn/courses/30/lessons/214288
 */

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int n = 5;
        int[][] reqs = new int[][]{
                {10, 60, 1},
                {15, 100, 3},
                {20, 30, 1},
                {30, 50, 3},
                {50, 40, 1},
                {60, 30, 2},
                {65, 30, 1},
                {70, 100, 2}
        };

        int result = 25;

        System.out.println(solution(k, n, reqs) == result);
    }

    public static int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        return answer;
    }
}
