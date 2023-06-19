package programmers.lv2.functiondevelopment;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] progresses1 = new int[]{93, 30, 55};
        int[] speeds1 = new int[]{1, 30, 5};
        int[] progresses2 = new int[]{95,90,99,99,80,99};
        int[] speeds2 = new int[]{1,1,1,1,1,1};
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] time = new int[progresses.length];
        for (int i = 0; i < time.length; i++) {
            time[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            System.out.printf("time[%d] = %d\n", i, time[i]);
        }

        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i < time.length; i++) {
            if (time[i] > time[idx]) {
                list.add(i - idx);
                idx = i;
            }
        }
        list.add(time.length - idx);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
