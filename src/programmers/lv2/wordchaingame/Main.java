package programmers.lv2.wordchaingame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int idx = 1;
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        while (true) {
            char end = words[idx - 1].charAt(words[idx - 1].length() - 1);
            char start = words[idx].charAt(0);
            if (start == end && !set.contains(words[idx])) {
                if (idx == words.length - 1) { // 마지막이라면
                    return new int[]{0, 0};
                }
                idx++;
            } else {
                break;
            }
        }

        int number = ((idx + 1) % n == 0) ? n : (idx + 1) % n;
        int order = (int) Math.ceil((idx + 1.0) / n);
        return new int[]{number, order};
    }
}
