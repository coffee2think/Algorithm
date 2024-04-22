package src.programmers.lv2.Q42587;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Programmers Q42587 lv2
 * Problem name: 프로세스
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */

public class Main {
    public static void main(String[] args) {
        // given
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 1;

        // when
        int result = new Main().solution(priorities, location);

        // then
        System.out.println("result: " + result + " is " + (result == answer ? "Correct!" : "Wrong.."));
    }

    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();

        // 우선순위들을 큐에 넣음
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(i, priorities[i]));
        }

        Arrays.sort(priorities);

        int order = 1; //  현재 순서를 저장할 변수
        int maxIndex = priorities.length - 1;
        while(!q.isEmpty()) {
            // 현재 프로세스의 우선순위가 가장 높은 우선순위라면
            if (q.peek().getPriority() == priorities[maxIndex]) {
                // 현재 프로세스가 찾고자 하는 프로세스라면 반복문 종료
                if (q.peek().getIndex() == location) {
                    break;
                }

                q.poll();
                maxIndex--;
                order++;
            } else {
                // 현재 프로세스를 큐에서 꺼내서 다시 넣음
                q.offer(q.poll());
            }
        }

        return order;
    }

    class Process {
        private int index;
        private int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        public int getIndex() {
            return this.index;
        }

        public int getPriority() {
            return this.priority;
        }
    }
}
