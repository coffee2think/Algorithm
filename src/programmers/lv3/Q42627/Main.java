package src.programmers.lv3.Q42627;

// link: https://school.programmers.co.kr/learn/courses/30/lessons/42627?language=java
// date: 2025-10-09

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // given
        int[][][] jobs = {
                {{0, 3}, {1, 9}, {3, 5}}
        };
        int[] answer = {
                8
        };

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Objects.deepEquals(solution(jobs[i]), answer[i])) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        // then
        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2025-10-09
    // * 문제를 풀며 배운 점
    // - Integer.compare() 사용 목적 : 오버플로우 문제를 피하기 위해 설계됨. Java 7 도입
    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
        PriorityQueue<Task> waitQueue = new PriorityQueue<>();

        int time = 0;
        int totalReturnTime = 0;
        int jobIndex = 0;
        int count = 0;
        int totalJobs = jobs.length;
        while (count < totalJobs) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                waitQueue.offer(new Task(jobIndex, jobs[jobIndex][0], jobs[jobIndex][1]));
                jobIndex++;
            }

            if (!waitQueue.isEmpty()) {
                Task task = waitQueue.poll();
                time += task.period;
                totalReturnTime += (time - task.requestTime);
                count++;
            } else {
                if (jobIndex < totalJobs) {
                    time = jobs[jobIndex][0];
                }
            }
        }

        return totalReturnTime / totalJobs;
    }

    public static class Task implements Comparable<Task> {
        int index;
        int requestTime;
        int period;

        public Task(int index, int requestTime, int period) {
            this.index = index;
            this.requestTime = requestTime;
            this.period = period;
        }

        @Override
        public int compareTo(Task other) {
            if (this.period != other.period) {
                return this.period - other.period;
            }
            if (this.requestTime != other.requestTime) {
                return this.requestTime - other.requestTime;
            }
            return this.index - other.index;
        }
    }
}
