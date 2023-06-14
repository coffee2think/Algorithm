package programmers.lv2.repeatBinaryConversion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        System.out.println(Arrays.toString(solution(s3)));
    }

    public static int[] solution(String s) {
        int zeroCount = 0;
        int runCount = 0;
        while(!s.equals("1")){
            runCount++;
            int zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0'){
                    zeros++;
                }
            }
            zeroCount += zeros;

            s = Integer.toBinaryString(s.length() - zeros);
        }

        return new int[]{runCount, zeroCount};
    }
}
