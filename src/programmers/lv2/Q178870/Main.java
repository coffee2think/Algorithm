package src.programmers.lv2.Q178870;

import java.util.Arrays;

/**
 * Programmers 178870 lv2
 * Problem name: 연속된 부분 수열의 합
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */

public class Main {
    public static void main(String[] args) {
        int[] sequence = {1,1,1,1,1,1,1};
        int k = 7;
        int[] answer = {0, 6};

        int[] result = new Main().solution(sequence, k);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.equals(answer, result) ? "Correct!" : "Wrong..");
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLength = sequence.length + 1;
        int sum = 0;

        for(int left = 0, right = 0; left < sequence.length; left++){
            while(right < sequence.length && sum < k){
                sum += sequence[right++];
            }

            if(sum == k && right - left < minLength){
                minLength = right - left;
                answer[0] = left;
                answer[1] = right - 1;
            }

            sum -= sequence[left];
        }

        return answer;
    }
}
