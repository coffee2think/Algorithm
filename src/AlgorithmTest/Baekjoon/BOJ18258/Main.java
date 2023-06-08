package AlgorithmTest.Baekjoon.BOJ18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.getSize()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.getFront()).append("\n");
                    break;
                case "back":
                    sb.append(queue.getBack()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Queue {
        private int size = 0;
        private int front = 0;
        private int back = -1;
        private int[] arr;

        public Queue(int size) {
            arr = new int[size];
        }

        public void push(int n) {
            arr[++back] = n;
            size = back - front + 1;
        }

        public int pop() {
            if (size == 0) return -1;
            else {
                int frontValue = arr[front++];
                size = back - front + 1;
                return frontValue;
            }
        }

        public int getSize() {
            return size;
        }

        public int isEmpty() {
            return (size == 0) ? 1 : 0;
        }

        public int getFront() {
            return (size == 0) ? -1 : arr[front];
        }

        public int getBack() {
            return (size == 0) ? -1 : arr[back];
        }
    }
}
