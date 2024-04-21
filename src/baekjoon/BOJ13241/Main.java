package src.baekjoon.BOJ13241;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(A * B / gcd(A, B));
        br.close();
    }

    public static long gcd(long A, long B){
//        if(B == 0){
//            return A;
//        } else{
//            return gcd(B, A % B);
//        }
        while (B != 0) {
            long r = A % B;
            A = B;
            B = r;
        }
        return A;
    }
}