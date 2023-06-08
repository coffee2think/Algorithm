package AlgorithmTest.Baekjoon.BOJ2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] samples = new int[N];
        int mean = 0, median, mode, range;

        for (int i = 0; i < N; i++) {
            samples[i] = Integer.parseInt(br.readLine());
            mean += samples[i];
        }

        Arrays.sort(samples);
        mean = (int)Math.round((double)mean / N);
        median = samples[(N - 1) / 2];
        mode = getMode(samples);
        range = samples[N - 1] - samples[0];

        System.out.println(mean + "\n" + median + "\n" + mode + "\n" + range);
        br. close();
    }

    public static int getMode(int[] arr) {
        int maxCnt = 1;
        int cnt = 1;
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) cnt = 1;
            else cnt++;

            if (cnt > maxCnt) {
                set.clear();
                set.add(arr[i]);
                maxCnt = cnt;
            } else if (cnt == maxCnt) {
                set.add(arr[i]);
            }
        }

        int[] setArr = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(setArr);
        if (setArr.length == 1)
            return setArr[0];
        else
            return setArr[1];
    }
}