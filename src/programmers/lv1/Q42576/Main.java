package src.programmers.lv1.Q42576;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[][] participant = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };

        String[][] completion = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };

        String[] answer = {
                "leo",
                "vinko",
                "mislav"
        };

        for (int i = 0; i < participant.length; i++) {
            if (answer[i].equals(solution(participant[i], completion[i]))) {
                System.out.println("정답입니다.");
            } else {
                System.out.println("틀렸습니다.");
            }
        }
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        String answer = null;
        for (String k : map.keySet()) {
            if (map.get(k) > 0) {
                answer = k;
            }
        }

        return answer;
    }
}
