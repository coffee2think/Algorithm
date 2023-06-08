package AlgorithmTest.Baekjoon.BOJ11729;

import java.io.*;

public class Main {
    static int cnt = 0; // 하노이 수의 경우 공식으로 계산 가능. But 그렇지 않은 경우 일일이 세어야함. cnt는 꼭 전역으로 세어야하는가?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N);
        br.close();
    }

    public static void hanoi(int size) {
        StringBuilder sb = new StringBuilder();
        hanoi(size, 1, 3, sb);
        System.out.println(cnt + "\n" + sb.toString());
    }

    private static void hanoi(int size, int from, int to, StringBuilder sb) {
        if (size == 0) {
//            cnt++;
//            sb.append(from + " " + to).append("\n"); // 출력하는 구문이 중복됨. 이것까지 줄일(통합할) 방법은?
            // size == 1일 때보다 한 단계 더 들어가서 오래 걸릴것으로 예상했으나
            // 실행 시간을 비교했을 때 큰 차이가 없었음. 메모리는 더 잡아먹을 수 있다.
            return;
        }

        int rest = 6 - from - to; // 1+2+3 = 6 이기 때문에 나머지 타워 번호 계산 가능

        hanoi(size - 1, from, rest, sb);
        cnt++;
        sb.append(from + " " + to).append("\n");
        hanoi(size - 1, rest, to, sb);
    }
}
