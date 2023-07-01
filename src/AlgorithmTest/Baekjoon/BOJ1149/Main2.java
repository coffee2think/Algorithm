package AlgorithmTest.Baekjoon.BOJ1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    // 상수를 이용하면 인덱스의 의미를 쉽게 파악할 수 있음
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];

        for (int i = 0; i < house.length; i++) {
            // 데이터 입력
            st = new StringTokenizer(br.readLine());
            house[i][RED] = Integer.parseInt(st.nextToken());
            house[i][GREEN] = Integer.parseInt(st.nextToken());
            house[i][BLUE] = Integer.parseInt(st.nextToken());

            // 입력과 동시에 최적해 계산
            if(i != 0){
                house[i][RED] += Math.min(house[i - 1][GREEN], house[i - 1][BLUE]);
                house[i][GREEN] += Math.min(house[i - 1][RED], house[i - 1][BLUE]);
                house[i][BLUE] += Math.min(house[i - 1][RED], house[i - 1][GREEN]);
            }
        }

        // 결과 출력
        int minResult = Math.min(Math.min(house[N - 1][RED], house[N - 1][GREEN]), house[N - 1][BLUE]);
        System.out.println(minResult);
    }
}
