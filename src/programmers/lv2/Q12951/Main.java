package src.programmers.lv2.Q12951;

import java.util.StringTokenizer;

/**
 * Programmers Q12951 lv2
 * Problem name: JadenCase 문자열 만들기
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */

public class Main {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        String answer = "3people Unfollowed Me";

        String result1 = new Main().solution1(s);
        System.out.println("solution1 result: " + result1);
        System.out.println(result1.equals(answer) ? "Correct!" : "Wrong...");

        String input = "   3people   unFollowed   me   ";
        String result2 = new Main().solution2(input);
        System.out.println("input: " + input);
        System.out.println("solution2 result: " + result2);
    }

    // 반복문을 이용한 풀이
    public String solution1(String s) {
        String lower = s.toLowerCase();
        char[] arr = lower.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            // 과거 풀이
//            if ((arr[i] >= 'a' && arr[i] <= 'z') && (i == 0 || arr[i - 1] == ' ')) {
//                arr[i] += 'A' - 'a';
//            }

            // 가독성 좋게 개선
            if (Character.isAlphabetic(arr[i]) && (i == 0 || arr[i - 1] == ' ')) {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }

        return String.valueOf(arr);
    }

    // 문제 변형 후 풀이
    // 조건 추가 : 공백은 단어와 단어 사이에만 사용할 수 있고, 공백이 연속해서 있는 경우 공백을 하나로 나타낸다.
    public String solution2(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            sb.append(token.substring(0, 1).toUpperCase())
                .append(token.substring(1).toLowerCase())
                .append(" ");
        }

        // 끝에 있는 공백 제거
        sb.replace(sb.length() - 1, sb.length(), "");

        return sb.toString().trim();
    }
}
