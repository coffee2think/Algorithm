package AlgorithmTest.Baekjoon.BOJ24060;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] sorted;
    static int cnt = 0;
    static int K;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        sorted = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr);
        System.out.println(answer);

        br.close();
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[idx++] = arr[l++];
            } else {
                sorted[idx++] = arr[r++];
            }

            if (++cnt == K) {
                answer = sorted[idx - 1];
            }
        }

        if (l > mid) {
            while (r <= right) {
                sorted[idx++] = arr[r++];
                if (++cnt == K) {
                    answer = sorted[idx - 1];
                }
            }
        } else {
            while (l <= mid) {
                sorted[idx++] = arr[l++];
                if (++cnt == K) {
                    answer = sorted[idx - 1];
                }
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
