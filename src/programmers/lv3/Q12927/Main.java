package src.programmers.lv3.Q12927;

import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arraySize = 20000;
        int[] works = new int[arraySize];
        int n = 1000000;

        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            works[i] = random.nextInt(50000) + 1; // 1 ~ 50000
        }

        long start = System.currentTimeMillis();
        System.out.println(solution(n, works));
        long end = System.currentTimeMillis();

        System.out.println("time : " + (end - start) + " ms");
    }

    public static long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.add(work);
        }

        for (int i = 0; i < n; i++) {
            int max = pq.poll();
            if (max == 0) {
                break;
            }
            pq.add(max - 1);
        }

        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}
