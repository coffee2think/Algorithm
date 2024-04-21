package src.programmers.lv2.Q181187;

/**
 * Programmers Q181187 lv2
 * Problem name: 두 원 사이의 정수 쌍
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/181187
 */

public class Main {
    public static void main(String[] args) {
        // given
        int r1 = 2;
        int r2 = 3;
        int answer = 20;

        // when
        long result = new Main().solution(r1, r2);

        // then
        System.out.printf("result: %d is %s\n", result, (result == answer) ? "Correct!" : "Wrong..");
    }

    public long solution(int r1, int r2) {
        long answer = 0;

        for(int x = 1; x <= r2; x++){
            int upperBound = (int) Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(x,2)));
            int lowerBound = (int) Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(x,2)));
            lowerBound = Math.max(lowerBound, 0); // 하한은 0

            answer += upperBound - lowerBound + 1;
        }

        answer *= 4;

        return answer;
    }
}
