package src.baekjoon.BOJ1735;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[2];
        int[] B = new int[2];

        for(int i=0; i<2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int denominator = B[0] * B[1];
        int numerator = A[0] * B[1] + A[1] * B[0];

        int gcd = gcd(denominator, numerator);
        numerator /= gcd;
        denominator /= gcd;

        System.out.println(numerator + " " + denominator);
        br.close();
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        } else{
            return gcd(b, a % b);
        }
    }
}