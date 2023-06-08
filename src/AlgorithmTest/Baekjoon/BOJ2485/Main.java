package AlgorithmTest.Baekjoon.BOJ2485;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        int[] interval = new int[N - 1];
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(trees);
        int gcd = 0;
        for(int i=0; i<trees.length - 1; i++){
            gcd = gcd(gcd, trees[i + 1] - trees[i]);
        }

        System.out.println((trees[N-1] - trees[0]) / gcd - N + 1);
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