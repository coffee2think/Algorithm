package src.baekjoon.BOJ18110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// link: https://www.acmicpc.net/problem/18110
// date: 2025-11-04
// average()의 결과로 OptionalDouble이 리턴되는데,
// stream이 비어있을 때 이것을 getAsDouble()로 가져올 시 NoSuchElementException이 발생할 수 있음
// Optional 객체를 사용할 때는 항상 이 점을 유의
// 방지법1 : isPresent()로 확인 후 getAsDouble()로 꺼내기
// 방지법2 : orElse(), orElseGet()를 사용하여 기본값을 리턴하거나, orElseThrow()를 사용하여 예외 발생
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] levels = new int[n];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int trim = (int) Math.round(n * 0.15);
        int average = (int) Math.round(
                Arrays.stream(levels).sorted()
                        .skip(trim).limit(n - trim * 2)
                        .average().orElse(0.0)
        );

        System.out.println(average);
        br.close();
    }
}
