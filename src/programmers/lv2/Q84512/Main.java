package src.programmers.lv2.Q84512;

/**
 * Programmers Q84512 lv2
 * Problem name: 모음사전
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */

public class Main {
    public static void main(String[] args) {
        String word = "EIO";
        int answer = 1189;

        int result = new Main().solution(word);
        System.out.println("result : " + result);
        System.out.println(answer == result ? "Correct!" : "Wrong...");
    }

    public int solution(String word) {
        int totalCases = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int prevCharacters = "AEIOU".indexOf(ch);

            totalCases += (int)(Math.pow(5, 5 - i) - 1) / 4 * prevCharacters + 1;
            totalCases += (i == 0) ? -1 : 0; // 모두 빈칸인 경우는 세지 않으므로 전체 경우의 수에서 제외
        }

        return totalCases + 1;
    }
}
