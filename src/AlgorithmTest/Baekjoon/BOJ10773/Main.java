package AlgorithmTest.Baekjoon.BOJ10773;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();
        int sum = 0;

        for (int i = 0; i < K; ++i) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0){
                sum -= stack.pop();
            } else{
//                stack.push(input);
//                sum += input;
                sum += stack.push(input);
            }
        }

        System.out.println(sum);
        br.close();
    }
}