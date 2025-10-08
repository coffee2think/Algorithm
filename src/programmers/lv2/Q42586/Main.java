package src.programmers.lv2.Q42586;

import java.util.*;

/**
 * Programmers Q42586 lv2
 * Problem name: 기능개발
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/42586
 *
 * ReviewDate: 2025-10-08
 */

public class Main {
    public static void main(String[] args) {
        int[][] progresses = {
                {93, 30, 55},
                {95,90,99,99,80,99}
        };
        int[][] speeds = {
                {1, 30, 5},
                {1,1,1,1,1,1}
        };
        int[][] answer = {
                {2, 1},
                {1, 3, 2}
        };

        int cases = answer.length;
        int answerCount = 0;
        for (int i = 0; i < cases; i++) {
            if (Arrays.equals(solutionRetry2(progresses[i], speeds[i]), answer[i])) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, cases, ((double)answerCount / cases * 100));
    }

    // 배열을 이용한 풀이
    public static int[] solution1(int[] progresses, int[] speeds) {
        // 기능별 남은 작업 기간
        int[] days = new int[progresses.length];
        for (int i = 0; i < days.length; i++) {
            days[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }

        // 배포할 기능 개수 구하기
        List<Integer> list = new ArrayList<>();
        int maxIndex = 0; // 최대 기간을 가리키는 인덱스
        for (int i = 1; i < days.length; i++) {
            if (days[i] > days[maxIndex]) {
                list.add(i - maxIndex);
                maxIndex = i;
            }
        }
        // 마지막 배포 기능 개수 추가
        list.add(days.length - maxIndex);

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 큐를 이용한 풀이
    public static int[] solution2(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        // 남은 작업 기간을 계산하여 큐에 넣음
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            q.offer(days);
        }

        // 배포별 기능 개수를 구함
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int currentDays = q.poll(); // 현재 배포의 작업 기간
            int completed = 1; // 완료된 기능 개수

            // 현재 작업 기간보다 적게 걸리는 경우 배포에 포함시킴
            while(!q.isEmpty() && q.peek() <= currentDays) {
                q.poll();
                completed++;
            }

            list.add(completed);
        }

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    // 큐를 이용한 방식
    // 푼 날짜: 2025-10-08
    public static int[] solutionRetry(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] leftDays = new int[n];
        for (int i = 0; i < n; i++) {
            leftDays[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        System.out.println("leftDays: " + Arrays.toString(leftDays));

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int current = leftDays[i];
            if (queue.isEmpty() || current <= queue.peek()) {
                queue.offer(current);
            } else if (current > queue.peek()) {
                list.add(queue.size());
                queue.clear();
                queue.offer(current);
            }
        }

        if (!queue.isEmpty()) {
            list.add(queue.size());
            queue.clear();
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        System.out.println("answer: " + Arrays.toString(answer));
        return answer;
    }

    // 투포인터를 이용한 방식
    // 푼 날짜: 2025-10-08
    public static int[] solutionRetry2(int[] progresses, int[] speeds) {
        int left = 0;
        int right = 0;

        int total = progresses.length;
        List<Integer> commits = new ArrayList<>();
        int headDays = calculateDays(progresses, speeds, left);
        for (int i = 0; i < total; i++) {
            int currentDays = calculateDays(progresses, speeds, i);
            if (currentDays > headDays) {
                right = i - 1;
                commits.add(right - left + 1); // 배포될 작업 개수 기록
                left = right = i;
                headDays = currentDays;
            }
        }

        // 마지막 남은 작업 확인
        if (left == right) {
            right = total - 1;
            commits.add(right - left + 1);
        }

        int[] answer = new int[commits.size()];
        for (int i = 0; i < commits.size(); i++) {
            answer[i] = commits.get(i);
        }
        return answer;
    }

    public static int calculateDays(int[] progresses, int[] speeds, int index) {
        return (int)Math.ceil((100.0 - progresses[index]) / speeds[index]);
    }
}
