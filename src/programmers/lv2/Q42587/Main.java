package src.programmers.lv2.Q42587;

import java.util.*;

/**
 * Programmers Q42587 lv2
 * Problem name: 프로세스
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * <p>
 * ReviewDate: 2025-10-09
 */

public class Main {
    public static void main(String[] args) {
        // given
        int[][] priorities = {
                {2, 1, 3, 2},
                {1, 1, 9, 1, 1, 1}
        };
        int[] location = {
                2,
                0
        };
        int[] answer = {
                1,
                5
        };

        // when
        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (solution2(priorities[i], location[i]) == answer[i]) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        // then
        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double) answerCount / cases * 100));
    }

    // solved date: 2024-04-22
    public static int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();

        // 우선순위들을 큐에 넣음
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(i, priorities[i]));
        }

        Arrays.sort(priorities);

        int order = 1; //  현재 순서를 저장할 변수
        int maxIndex = priorities.length - 1;
        while (!q.isEmpty()) {
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

    public static class Process {
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

    // 2025-10-09 배운점
    // - 중첩 클래스(nested class): 클래스가 다른 클래스의 멤버로 정의된 것
    // - 중첩 클래스를 구현한 경우, static 메서드에서 inner class를 사용하기 위한 inner class의 static 조건
    // - static이 붙지 않은 inner class는 outer class의 인스턴스에 종속됨 → outer class의 인스턴스가 존재해야 사용 가능
    // - static 메서드에서 inner class를 사용하기 위해서는 static 키워드 필요!

    // solved date: 2025-10-09
    public static int solution2(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            q.offer(i);
            count[priorities[i]]++;
        }

        int order = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (existsHigherPriority(count, priorities[current])) {
                q.offer(current);
                continue;
            }

            order++;
            count[priorities[current]]--;
            if (current == location) {
                break;
            }
        }

        return order;
    }

    public static boolean existsHigherPriority(int[] count, int priority) {
        for (int i = count.length - 1; i > priority; i--) {
            if (count[i] > 0) {
                return true;
            }
        }
        return false;
    }
}
