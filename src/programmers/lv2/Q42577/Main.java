package src.programmers.lv2.Q42577;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] phone_book = {
                {"119", "97674223", "1195524421"},
                {"123", "456", "789"},
                {"12", "123", "1235", "567", "88"}
        };

        boolean[] answer = {
                false,
                true,
                false
        };

        int total = phone_book.length;
        int answerCount = 0;
        for (int i = 0; i < total; i++) {
            if (solution(phone_book[i]) == answer[i]) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, total, ((double)answerCount / total));

        String[] test = {"114", "11", "14", "13", "11473"};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
