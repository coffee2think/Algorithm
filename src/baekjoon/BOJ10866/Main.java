package src.baekjoon.BOJ10866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque deque = new Deque();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(deque.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static class Deque {
        private int size = 0;
        private LinkedList<Integer> deque = new LinkedList<>();

        public void push_front(int n) {
            deque.offerFirst(n);
            size++;
        }

        public void push_back(int n) {
            deque.offerLast(n);
            size++;
        }

        public int pop_front() {
            if (size == 0) return -1;
            else {
                size--;
                return deque.pollFirst();
            }
        }

        public int pop_back() {
            if (size == 0) return -1;
            else {
                size--;
                return deque.pollLast();
            }
        }

        public int size() {
            return size;
        }

        public int empty() {
            return (size == 0) ? 1 : 0;
        }

        public int front() {
            if (size == 0) return -1;
            else return deque.getFirst();
        }

        public int back() {
            if (size == 0) return -1;
            else return deque.getLast();
        }
    }
}
