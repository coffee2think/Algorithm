package src.baekjoon.BOJ30970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baekjoon Q30970 실버4
 * Problem name: 선택의 기로
 * link: https://www.acmicpc.net/problem/30970
 */

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        System.out.println("solution1 ----------------------");
        solution1();
        System.out.println("solution2 ----------------------");
        solution2();

        br.close();
    }

    // solution1 : 배열 이용
    public static void solution1() throws IOException {
        // given
        int N = Integer.parseInt(br.readLine());
        Miniature[] miniatures = new Miniature[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int quality = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            miniatures[i] = new Miniature(quality, price);
        }

        // when
        // 방법1 : 품질 내림차순 후 가격 오름차순
        Arrays.sort(miniatures, (m1, m2) -> {
            if (m1.getQuality() == m2.getQuality()) {
                return m1.getPrice() - m2.getPrice();
            }

            return m2.getQuality() - m1.getQuality();
        });

        // 방법1 결과 기록
        sb.append(miniatures[0]).append(" ").append(miniatures[1]).append("\n");

        // 방법2 : 가격 오름차순 후 품질 내림차순
        Arrays.sort(miniatures, (m1, m2) -> {
            if (m1.getPrice() == m2.getPrice()) {
                return m2.getQuality() - m1.getQuality();
            }

            return m1.getPrice() - m2.getPrice();
        });

        // 방법2 결과 기록
        sb.append(miniatures[0]).append(" ").append(miniatures[1]).append("\n");

        // then
        System.out.println(sb.toString());
    }

    // solution2 : 힙(우선순위큐) 사용
    public static void solution2() throws IOException {
        // given
        int N = Integer.parseInt(br.readLine());

        // 방법1 우선순위큐 : 품질 내림차순 후 가격 오름차순
        PriorityQueue<Miniature> approach1 = new PriorityQueue<>((m1, m2) -> {
            if (m1.getQuality() == m2.getQuality()) {
                return m1.getPrice() - m2.getPrice();
            }

            return m2.getQuality() - m1.getQuality();
        });

        // 방법2 우선순위큐 : 가격 오름차순 후 품질 내림차순
        PriorityQueue<Miniature> approach2 = new PriorityQueue<>((m1, m2) -> {
            if (m1.getPrice() == m2.getPrice()) {
                return m2.getQuality() - m1.getQuality();
            }

            return m1.getPrice() - m2.getPrice();
        });

        // 미니어처 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int quality = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            Miniature miniature = new Miniature(quality, price);

            approach1.add(miniature);
            approach2.add(miniature);
        }

        // 방법1 결과 기록
        sb.append(approach1.poll()).append(" ").append(approach1.poll()).append("\n");
        // 방법2 결과 기록
        sb.append(approach2.poll()).append(" ").append(approach2.poll()).append("\n");

        // then
        System.out.println(sb.toString());
    }

}

class Miniature {
    private int quality;
    private int price;

    public Miniature(int quality, int price) {
        this.quality = quality;
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return quality + " " + price;
    }
}