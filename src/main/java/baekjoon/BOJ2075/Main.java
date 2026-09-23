package baekjoon.BOJ2075;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// source: https://www.acmicpc.net/problem/2075

public class Main {
    public static void main(String[] args) throws Exception {
        improvedSolution2();
    }

    public static void solution1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int row = 0; row < N; row++) {
            String[] tokens = br.readLine().split(" ");
            for (int col = 0; col < N; col++) {
                pq.offer(Integer.parseInt(tokens[col]));
            }
        }

        // solution
        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        int answer = pq.poll();

        // output
        System.out.println(answer);
        br.close();
    }

    public static void solution2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // 테이블에서 각 열의 마지막 행을 참조하기 위해 Stack 구조 사용
        List<Stack<Integer>> table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new Stack<>());
        }

        // 테이블 입력
        for (int row = 0; row < N; row++) {
            String[] tokens = br.readLine().split(" ");
            for (int col = 0; col < N; col++) {
                table.get(col).push(Integer.parseInt(tokens[col]));
            }
        }

        // solution
        // 각 열의 마지막 행으로 내림차순 정렬한 MaxHeap
        PriorityQueue<Stack<Integer>> pq = new PriorityQueue<>((stack1, stack2) -> stack2.peek() - stack1.peek());
        for (int i = 0; i < N; i++) {
            pq.add(table.get(i));
        }

        // (N - 1)번 최댓값 원소들을 제거
        for (int i = 0; i < N - 1; i++) {
            Stack<Integer> polledStack = pq.poll();
            polledStack.pop();
            pq.offer(polledStack);
        }

        // N번째로 큰 원소
        int answer = pq.poll().pop();

        // output
        System.out.println(answer);
        br.close();
    }

    // solution2 개선
    public static void improvedSolution2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* given */
        int N = Integer.parseInt(br.readLine());

        // Stack 대신 배열과 인덱스 사용
        int[][] table = new int[N][N];
        int[] currentIndex = new int[N];

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(tokens[j]);
            }
            currentIndex[i] = N - 1;  // 각 열의 마지막 인덱스
        }

        /* solution */
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (col1, col2) -> table[currentIndex[col2]][col2] - table[currentIndex[col1]][col1]
        );

        for (int i = 0; i < N; i++) {
            pq.offer(i);
        }

        for (int i = 0; i < N - 1; i++) {
            int col = pq.poll();
            currentIndex[col]--;
            pq.offer(col);
        }

        /* output */
        int answerCol = pq.poll();
        int answer = table[currentIndex[answerCol]][answerCol];
        System.out.println(answer);
        br.close();
    }

    public static void solution3() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // 테이블에서 각 열의 마지막 행을 참조하기 위해 Stack 자료구조 사용
        List<Stack<Integer>> table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new Stack<>());
        }

        // 테이블 입력
        for (int row = 0; row < N; row++) {
            String[] tokens = br.readLine().split(" ");
            for (int col = 0; col < N; col++) {
                table.get(col).push(Integer.parseInt(tokens[col]));
            }
        }

        // solution
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int col = 0; col < N; col++) {
            map.put(table.get(col).pop(), col);
        }

        for (int n = 0; n < N - 1; n++) {
            Map.Entry<Integer, Integer> firstEntry = map.pollFirstEntry();
            int columnIndex = firstEntry.getValue();
            map.put(table.get(columnIndex).pop(), columnIndex);
        }

        // output
        System.out.println(map.firstEntry().getKey());
        br.close();
    }

    public static void solution4() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* given */
        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N];
        for (int row = 0; row < table.length; row++) {
            String[] tokens = br.readLine().split(" ");
            for (int col = 0; col < table[0].length; col++) {
                table[row][col] = Integer.parseInt(tokens[col]);
            }
        }

        /* solution */
        PriorityQueue<Node> maxHeap = new PriorityQueue<>();

        // 각 열의 가장 큰 요소들이 있는 마지막 행 추가
        for (int col = 0; col < N; col++) {
            maxHeap.add(new Node(table[N - 1][col], N - 1, col));
        }

        // 가장 큰 숫자를 제거하고, 해당 숫자가 포함되었던 열의 다음 큰 숫자를 maxHeap에 추가
        // (N - 1) 번 반복
        for (int i = 0; i < N - 1; i++) {
            Node current = maxHeap.poll();

            int row = current.row;
            int col = current.col;

            maxHeap.offer(new Node(table[row - 1][col], row - 1, col));
        }

        int result = maxHeap.poll().value;

        /* output */
        System.out.println(result);
        br.close();
    }

    static class Node implements Comparable<Node> {
        int value;
        int row, col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        // value를 기준으로 내림차순 정렬
        @Override
        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }
}
