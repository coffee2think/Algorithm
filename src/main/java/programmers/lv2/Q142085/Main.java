package programmers.lv2.Q142085;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Programmers Q142085 lv
 */

public class Main {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = new int[]{4, 2, 4, 5, 3, 3, 1};

        System.out.println("answer : " + solution(n, k, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        int round = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < enemy.length; i++) {
            // 리스트에 적을 추가하고
            list.add(enemy[i]);

            // 라운드가 무적권의 개수(k)를 넘어가면 방어가능여부를 판단한다
            // 방어 불가능하면 반복문을 탈출
            if (i + 1 > k && !isBlockable(n, k, list)) {
                break;
            }

            // 방어 가능한 round 수를 증가시킨다
            round++;
        }

        return round;
    }

    public static boolean isBlockable(int n, int k, List<Integer> list) {
        // 리스트 오름차순 정렬
        list.sort(Comparator.naturalOrder());

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            // 리스트의 작은 수부터 순서대로 더하고
            // 합계가 n을 초과하면, 남은 개수를 무적권의 개수(k)와 비교하여 방어 가능 여부를 리턴
            sum += list.get(i);

            if (sum > n) {
                return list.size() - i <= k;
            }
        }

        // list 내의 모든 적을 n으로 막을 수 있는 경우 true 리턴
        return true;
    }
}
