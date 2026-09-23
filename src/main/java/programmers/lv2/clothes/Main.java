package programmers.lv2.clothes;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] item : clothes) {
            map.put(item[1], map.getOrDefault(item[1], 0) + 1);
        }

        int cases = 1;
        for(String key : map.keySet()){
            cases *= map.get(key) + 1;
        }

        return cases - 1;
    }
}
