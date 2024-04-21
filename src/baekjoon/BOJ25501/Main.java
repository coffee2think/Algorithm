package src.baekjoon.BOJ25501;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            sb.append(isPalindrome(str) + " " + recursionCount(str, 0, str.length() - 1, 0) + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int recursionCount(String s, int l, int r, int cnt){
        if (l >= r) return ++cnt;
        else if (s.charAt(l) != s.charAt(r)) return ++cnt;
        else return recursionCount(s, l + 1, r - 1, ++cnt);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
