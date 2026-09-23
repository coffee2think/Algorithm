package programmers.lv2.expressionOfNumber;

public class Main {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int cnt = 0;
        double a = n;

        for (int i = 1; a >= 1; i++) {
            if (a == (int) a) {
                cnt++;
            }
            a = (2.0 * n / (i + 1) - i) / 2;
        }

        return cnt;
    }
}
