package src.baekjoon.BOJ1934;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int gcd = gcd(A, B);
            int lcm = A * B / gcd;

            sb.append(lcm + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static int gcd(int A, int B){
        if(B == 0){
            return A;
        } else{
            return gcd(B, A % B);
        }
    }
}