package AlgorithmTest.Baekjoon.BOJ1931;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // Comparator를 이용한 정렬
//        Arrays.sort(meetings, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[1] != o2[1]){
//                    return o1[1] - o2[1];
//                }
//
//                return o1[0] - o2[0]; // else도 연산이기 때문에 이런식으로 else를 안쓴다면 성능을 조금이나마 향상시킬 수 있음
//            }
//        });

        // 람다식을 이용한 정렬1
//        Arrays.sort(meetings, (a1, a2) -> {
//            if (a1[1] != a2[1]) return a1[1] - a2[1];
//            return a1[0] - a2[0];
//        });

        // 람디식을 이용한 정렬2
        Arrays.sort(meetings, (a1, a2) -> a1[1] != a2[1] ? a1[1] - a2[1] : a1[0] - a2[0]);

        int endTime = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
