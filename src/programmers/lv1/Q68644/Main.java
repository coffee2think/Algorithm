package src.programmers.lv1.Q68644;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] result = solution(numbers);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
