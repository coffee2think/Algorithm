package src.programmers.lv2.Q70129;

import java.util.Arrays;
import java.util.Random;

/**
 * Programmers Q70129 lv2
 * Problem name: 이진 변환 반복하기
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */

public class Main {
    public static void main(String[] args) {
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

//        System.out.println(Arrays.toString(new Main().solution2(s1)));
//        System.out.println(Arrays.toString(new Main().solution2(s2)));
//        System.out.println(Arrays.toString(new Main().solution2(s3)));

        // solution1과 solution2의 성능 비교
        Random random = new Random();
        int cnt = 0;
        int tryCount = 10000;

        for (int i = 0; i < tryCount; i++) {
            // 1 이상 150,000 이하의 길이를 가지는 0과 1로 이루어진 문자열 s를 생성
            int length = random.nextInt(150000) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(random.nextInt(2));
            }
            String s = sb.toString();

            long before1 = System.nanoTime();
            int[] solution1 = new Main().solution1(s);
            long after1 = System.nanoTime();
            long time1 = after1 - before1;

            long before2 = System.nanoTime();
            int[] solution2 = new Main().solution2(s);
            long after2 = System.nanoTime();
            long time2 = after2 - before2;

            if (time1 > time2) {
                // solution2가 solution1보다 20% 이상 빠른 경우 카운트
                if (1 - time1 / time2 >= 0.2) {
                    cnt++;
                }

//                System.out.println("solution2 is faster than solution1");
            } else {
//                System.out.println("solution1 is faster than solution2");
            }
        }

        // solution2가 solution1보다 몇 %의 경우에 더 빨랐는지 결과문 출력
        System.out.println("solution2 is faster than solution1 in " + ((double) cnt / tryCount * 100) + "% cases");
    }

    // 반복문을 통해 문자열 s를 순회하는 풀이
    public int[] solution1(String s) {
        int zeros = 0; // 0의 누적 개수
        int runtimes = 0; // 실행 횟수

        while(!s.equals("1")){
            int zero = 0; // 0의 개수

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
            }

            zeros += zero;
            s = Integer.toBinaryString(s.length() - zero);
            runtimes++;
        }

        return new int[]{runtimes, zeros};
    }

    // Integer 클래스의 비트 관련 메소드를 사용한 풀이
    public int[] solution2(String s) {
        int zeros = 0; // 0의 누적 개수
        int runtimes = 1; // 실행 횟수

        // 문자열에 포함된 0의 개수
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            }
        }

        // 문자열을 숫자 변환하여 이진 변환 수행
        int num = s.length() - zeros;
        while(num != 1){
            int binaryLength = 32 - Integer.numberOfLeadingZeros(num);
            int zero = binaryLength - Integer.bitCount(num);

            zeros += zero;
            num = binaryLength - zero;
            runtimes++;
        }

        return new int[]{runtimes, zeros};
    }
}
