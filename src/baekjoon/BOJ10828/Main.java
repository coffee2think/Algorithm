package src.baekjoon.BOJ10828;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        for (int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop() + "\n");
                    break;
                case "size":
                    sb.append(stack.getSize() + "\n");
                    break;
                case "empty":
                    sb.append((stack.getTop() == -1 ? 1 : 0) + "\n");
                    break;
                case "top":
                    sb.append(stack.getTop() + "\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static class Stack {
        List<Integer> list = new ArrayList<>();

        public void push(int item) {
            list.add(item);
        }

        public int pop(){
            if (list.isEmpty()) {
                return -1;
            } else {
                int top = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                return top;
            }
        }

        public int getTop() {
            if(list.isEmpty())
                return -1;
            else
                return list.get(list.size() - 1);
        }

        public int getSize() {
            return list.size();
        }
    }
}