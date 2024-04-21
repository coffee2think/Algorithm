package src.baekjoon.BOJ28278;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCount = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        for (int t = 0; t < testCount; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    sb.append(stack.pop()).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty()).append("\n");
                    break;
                case 5:
                    sb.append(stack.peek()).append("\n");
                    break;
                default:
                    throw new NoSuchMethodException();
            }
        }

        System.out.println(sb.toString());
    }

    public static class Stack {
        private List<Integer> stack;

        public Stack() {
            stack = new ArrayList<>();
        }

        public void push(int n) {
            stack.add(n);
        }

        public int pop() {
            if (stack.size() == 0) {
                return -1;
            }

            int topIdx = stack.size() - 1;
            int topValue = stack.get(topIdx);
            stack.remove(topIdx);
            return topValue;
        }

        public int size() {
            return stack.size();
        }

        public int isEmpty() {
            if (stack.size() == 0) {
                return 1;
            }

            return 0;
        }

        public int peek() {
            if (stack.size() == 0) {
                return -1;
            }

            return stack.get(stack.size() - 1);
        }
    }
}


