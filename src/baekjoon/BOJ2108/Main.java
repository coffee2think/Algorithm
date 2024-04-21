package src.baekjoon.BOJ2108;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] samples = new int[8001]; // 빈도수를 저장할 배열
        int mean = 0, median = 5000, mode = 5000, range;
        int max = -4000, min = 4000;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            samples[num + 4000]++;
            mean += num;
            if(num > max) max = num;
            if(num < min) min = num;
        }

        mean = (int)Math.round((double)mean / N); // 평균을 계산한 후 반올림
        range = max - min;

        int accFreq = 0; // 누적빈도수를 저장할 변수
        int maxFreq = 0; // 최대빈도수를 저장할 변수
        boolean flag = false; // 최대빈도수 중복을 확인할 변수
        for (int i = min + 4000; i <= max + 4000; i++) {
            if(samples[i] == 0) continue;

            // 중앙값 찾기 : 이전 누적수가 절반을 넘지 못하는 동안 갱신
            if (accFreq < (N + 1) / 2) {
                accFreq += samples[i];
                median = i - 4000;
            }

            // 최반값 찾기
            if (samples[i] > maxFreq) {
                maxFreq = samples[i];
                mode = i - 4000;
                flag = true;
            } else if (samples[i] == maxFreq && flag) {
                mode = i - 4000;
                flag = false;
            }
        }

        System.out.println(mean + "\n" + median + "\n" + mode + "\n" + range);
        br. close();
    }
}