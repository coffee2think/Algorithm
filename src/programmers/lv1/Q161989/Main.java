package src.programmers.lv1.Q161989;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = new int[]{2, 3, 6};
        int result = 2;

        System.out.println(solution(n, m, section) == result);
    }

    public static int solution(int n, int m, int[] section) {
        int painted = section[0]; // 페인트로 칠한 구간
        int cnt = 1;

        for (int i = 1; i < section.length; i++) {
            if (section[i] >= painted + m) {
                painted = section[i];
                cnt++;
            }
        }

        return cnt;
    }
}
