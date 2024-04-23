package src.baekjoon.Q24511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Baekjoon Q24511 실버3
 * Problem name: queuestack
 * link: https://www.acmicpc.net/problem/24511
 */

public class Main {
    public static void main(String[] args) throws IOException {
        solution2();
    }

    // Deque 사용
    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());
        boolean[] isQueue = new boolean[N]; // 큐면 true, 스택이면 false

        // isQueue 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            isQueue[i] = Integer.parseInt(st.nextToken()) == 0 ? true : false;
        }

        // 스택이면 입력하는 값을 그대로 pop하므로 리턴값에 아무런 영향을 주지 않는다.
        // 큐인 경우에는 가지고 있던 값을 pop하므로, queuestack을 연결된 큐로 생각하면 전체 구조는 큐 구조를 갖게 된다.
        // 따라서 queuestack이 큐인 경우만 큐에 값을 삽입한다.
        // 큐에 값을 넣을 때는 뒤에서부터 꺼내야 하므로 Deque 사용
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (isQueue[i]) {
                deque.add(num);
            }
        }

        // when
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // 입력을 앞쪽으로 넣으므로 덱을 이용하여 앞에 넣고, 뒤로 뺌
        while (M --> 0) {
            deque.addFirst(Integer.parseInt(st.nextToken()));
            sb.append(deque.pollLast()).append(" ");
        }

        // then
        System.out.println(sb.toString().substring(0, sb.length() - 1)); // 뒤에 공백 한개 제거
        br.close();
    }

    // Stack 사용
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());
        boolean[] isQueue = new boolean[N]; // 큐면 true, 스택이면 false

        // isQueue 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            isQueue[i] = Integer.parseInt(st.nextToken()) == 0 ? true : false;
        }

        // 스택이면 입력하는 값을 그대로 pop하므로 리턴값에 아무런 영향을 주지 않는다.
        // 큐인 경우에는 가지고 있던 값을 pop하므로, queuestack을 연결된 큐로 생각하면 전체 구조는 큐 구조를 갖게 된다.
        // 따라서 queuestack가 큐인 경우만 값을 삽입한다.
        // 뒤에서부터 꺼낼 것이므로 Stack 사용
        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (isQueue[i]) {
                stack.push(num);
            }
        }

        // when
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            // 스택에 담겨져있는 것을 먼저 꺼내고, 그 이후는 입력한 값들을 출력
            sb.append(!stack.isEmpty() ? stack.pop() : Integer.parseInt(st.nextToken())).append(" ");
        }

        // then
        System.out.println(sb.toString());
        br.close();
    }
}
