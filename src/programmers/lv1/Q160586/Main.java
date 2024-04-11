package src.programmers.lv1.Q160586;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Programmers Q160586 lv1
 * Problem name: 대충 만든 자판
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */

public class Main {
    private static final int MAX_KEYMAP_LENGTH = 100;

    public static void main(String[] args) {
        // ["ABACD", "BCEFD"]
        String[] keymap = new String[]{"ABACD", "BCEFD"};
        String[] targets = new String[]{"ABCD","AABB"};
        int[] result = new int[]{9, 4};

        System.out.println(Arrays.toString(new Main().solution1(keymap, targets)));
        System.out.println(Arrays.toString(new Main().solution2(keymap, targets)));
    }

    public int[] solution1(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> minTouch = new HashMap<>();

        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char ch = keys.charAt(i); // 현재 문자
                int min = Math.min(i + 1, minTouch.getOrDefault(ch, i + 1)); // 해당 문자의 최소 터치 횟수
                minTouch.put(ch, min);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int touch = 0; // 누적 터치 횟수

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);

                // map에서 값을 가져와서 누적함
                // NPE 발생 시 작성할 수 없는 경우이므로 -1
                try {
                    touch += minTouch.get(ch);
                } catch (NullPointerException e) {
                    touch = -1;
                    break;
                }
            }

            answer[i] = touch;
        }

        return answer;
    }

    // 큐를 이용한 풀이
    public int[] solution2(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] minTouch = new int[26];
        Arrays.fill(minTouch, MAX_KEYMAP_LENGTH + 1);

        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char ch = keys.charAt(i);
                int min = Math.min(i + 1, minTouch[ch - 'A']);
                minTouch[ch - 'A'] = min;
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int touch = 0;

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                if (minTouch[ch - 'A'] == 101) {
                    touch = -1;
                    break;
                }
                touch += minTouch[ch - 'A'];
            }

            answer[i] = touch;
        }

        return answer;
    }
}
