package src.programmers.lv2.Q42586;

import java.util.*;

/**
 * Programmers Q42586 lv2
 * Problem name: 기능개발
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

public class Main {
    public static void main(String[] args) {
        int[] progresses1 = new int[]{93, 30, 55};
        int[] speeds1 = new int[]{1, 30, 5};
        int[] progresses2 = new int[]{95,90,99,99,80,99};
        int[] speeds2 = new int[]{1,1,1,1,1,1};

        System.out.println(Arrays.toString(new Main().solution1(progresses2, speeds2)));
        System.out.println(Arrays.toString(new Main().solution2(progresses2, speeds2)));
    }

    // 배열을 이용한 풀이
    public int[] solution1(int[] progresses, int[] speeds) {
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
    public int[] solution2(int[] progresses, int[] speeds) {
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
}
