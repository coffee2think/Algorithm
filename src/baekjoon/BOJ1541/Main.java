package src.baekjoon.BOJ1541;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expr = br.readLine();
        String[] numsStr = expr.split("[+-]");
        String[] operStr = expr.split("[0-9]+"); // [0-9] == \\d
        int[] nums = new int[numsStr.length];
        int[] psum = new int[nums.length + 1];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
            psum[i + 1] = psum[i] + nums[i];
        }

        char[] operations = new char[operStr.length];
        for (int i = 1; i < operations.length; i++) {
            operations[i] = operStr[i].charAt(0);
        }
        operStr = null;

        // 기본 아이디어 : -가 등장하면 이후의 값들을 모두 뺀다.
        int result = psum[psum.length - 1];
        for (int i = 1; i < operations.length; i++) {
            if (operations[i] == '-') {
                result = psum[i] - (psum[psum.length - 1] - psum[i]);
                break;
            }
        }

        // String.contains()를 활용한 방법
//        int result;
//        if(expr.contains("-")){ // "-"를 보유하고 있다면 -의 순서를 찾음
//            for (int i = 1; i < operations.length; i++) {
//                if (operations[i] == '-') {
//                    result = psum[i] - (psum[psum.length - 1] - psum[i]);
//                    break;
//                }
//            }
//        } else { // "-"를 보유하고 있지 않다면 끝까지의 합을 결과에 대입
//            result = psum[psum.length - 1];
//        }

        System.out.println(result);
        br.close();
    }
}
