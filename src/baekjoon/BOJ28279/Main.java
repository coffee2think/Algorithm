package src.baekjoon.BOJ28279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon Q28279 실버4
 * Problem name: 덱 2
 * link: https://www.acmicpc.net/problem/28279
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque deque = new Deque(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch(command) {
                case 1: deque.addFirst(Integer.parseInt(st.nextToken())); break;
                case 2: deque.addLast(Integer.parseInt(st.nextToken())); break;
                case 3: sb.append(deque.removeFirst()).append("\n"); break;
                case 4: sb.append(deque.removeLast()).append("\n"); break;
                case 5: sb.append(deque.size()).append("\n"); break;
                case 6: sb.append(deque.isEmpty()).append("\n"); break;
                case 7: sb.append(deque.peekFirst()).append("\n"); break;
                case 8: sb.append(deque.peekLast()).append("\n"); break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + command);
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}

class Deque {
    private int[] deque;
    private int first;
    private int last;
    private int subFirst;
    private int subLast;

    public Deque(int N) {
        deque = new int[N];
        first = N;
        last = -1;
        subFirst = N - 1;
        subLast = 0;
    }

    public void addFirst(int x) {
        deque[--first] = x;
    }

    public void addLast(int x) {
        deque[++last] = x;
    }

    public int removeFirst() {
        return this.isEmpty() == 1 ? -1 : (first > subFirst ? deque[subLast++] : deque[first++]);
    }

    public int removeLast() {
        return this.isEmpty() == 1 ? -1 : (last < subLast ? deque[subFirst--] : deque[last--]);
    }

    public int size() {
        int front = subFirst - first + 1;
        int back = last - subLast + 1;
        return front + back;
    }

    public int isEmpty() {
        return this.size() == 0 ? 1 : 0;
    }

    public int peekFirst() {
        return this.isEmpty() == 1 ? -1 : (first > subFirst ? deque[subLast] : deque[first]);
    }

    public int peekLast() {
        return this.isEmpty() == 1 ? -1 : (last < subLast ? deque[subFirst] : deque[last]);
    }
}
