package programmers.lv2.discountevent;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] want = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number = new int[]{3, 2, 2, 2, 1};
        String[] discount = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            String item = discount[i];
            int idx = isContained(want, item);
            if (idx != -1) {
                number[idx]--;
            }
        }

        if (isSatisfied(number)) cnt++;
        for (int i = 10; i < discount.length; i++) {
            String item = discount[i - 10];
            int idx = isContained(want, item);
            if (idx != -1) number[idx]++;

            item = discount[i];
            idx = isContained(want, item);
            if (idx != -1) number[idx]--;

            if(isSatisfied(number)) cnt++;
        }

        return cnt;
    }

    public static int isContained(String[] want, String item) {
        for (int i = 0; i < want.length; i++) {
            if (item.equals(want[i]))
                return i;
        }
        return -1;
    }

    public static boolean isSatisfied(int[] number) {
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 0)
                sum += number[i];
        }

        if (sum == 0)
            return true;
        else
            return false;
    }
}
