package src.programmers.lv2.Q42578;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[][][] clothes = {
                {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}},
                {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}
        };

        int[] answer = {
                5,
                3
        };

        int total = clothes.length;
        int answerCount = 0;
        for (int i = 0; i < total; i++) {
            if (solution(clothes[i]) == answer[i]) {
                System.out.println((i + 1) + ". 정답입니다.");
                answerCount++;
            } else {
                System.out.println((i + 1) + ". 틀렸습니다.");
            }
        }

        System.out.printf("정답률 : %d / %d (%.1f%%)\n", answerCount, total, ((double)answerCount / total * 100));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] item : clothes) {
            String type = item[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int cases = 1;
        for (String type : map.keySet()) {
            cases *= map.get(type) + 1;
        }

        return cases - 1;
    }
}
