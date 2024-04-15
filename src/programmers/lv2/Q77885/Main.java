package src.programmers.lv2.Q77885;

import java.util.Arrays;

/**
 * Programmers Q77885 lv2
 * Problem name: 2개 이하로 다른 비트
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/77885
 */

public class Main {
    public static void main(String[] args) {
        long[] numbers = new long[]{2, 7};
        long[] answer = new long[]{3, 11};

        System.out.println(Arrays.toString(new Main().solution1(numbers)));
        System.out.println(Arrays.toString(new Main().solution2(numbers)));
    }

    // 바이너리 스트링을 이용한 방법
    public long[] solution1(long[] numbers) {
        long[] f = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            // 2진수로 변환 후 가장 오른쪽 0비트의 위치를 찾아 바로 다음 비트에 1비트를 더한 값을 f에 저장
            StringBuilder bin = new StringBuilder(Long.toBinaryString(x));
            int lowestZeroIndex = bin.lastIndexOf("0");
            f[i] = x + (long) Math.pow(2, Math.max(bin.length() - lowestZeroIndex - 2, 0));
        }

        return f;
    }

    // 비트 연산을 이용한 방법
    public long[] solution2(long[] numbers) {
        long[] f = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            f[i] = x + Math.max(((~x & (x + 1)) >>> 1), 1);
        }

        return f;
    }
}
