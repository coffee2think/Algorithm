package src.programmers.lv1.Q68644;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        int[] numbers = {2,1,3,4,1};
        int arraySize = 10000;
        int[] numbers = new int[arraySize];
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = random.nextInt(101);
        }

        long start1 = System.nanoTime();
        int[] result1 = solution1(numbers);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        int[] result2 = solution2(numbers);
        long end2 = System.nanoTime();

        System.out.println("result1 time : " + ((end1 - start1) / 1000000) + " ms");
        System.out.println("result2 time : " + ((end2 - start2) / 1000000) + " ms");
    }

    public static int[] solution1(int[] numbers) {
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

    public static int[] solution2(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        Integer[] result = set.toArray(new Integer[0]);
        int[] answer = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            answer[i] = result[i];
        }

        return answer;
    }
}
