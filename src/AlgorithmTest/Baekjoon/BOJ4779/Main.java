package AlgorithmTest.Baekjoon.BOJ4779;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            System.out.println(cantorize(N));
        }
        br.close();
    }

    public static String cantorize(int n) {
        int powerOfThree = (int) Math.pow(3, n);
        char[] arr = new char[powerOfThree];
        Arrays.fill(arr, '-');
        return String.valueOf(cantorize(arr, 0, arr.length - 1));
    }

    private static char[] cantorize(char[] arr, int left, int right) {
        if (left == right) return arr;

        int length = right - left + 1;

        int trisection1 = left + length / 3; // 첫번째 3등분점
        int trisection2 = left + length / 3 * 2; // 두번째 3등분점

        for (int i = trisection1; i < trisection2; i++) {
            arr[i] = ' ';
        }

        arr = cantorize(arr, left, trisection1 - 1);
        arr = cantorize(arr, trisection2, right);

        return arr;
    }
}
