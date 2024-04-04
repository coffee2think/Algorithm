package src.programmers.lv1.Q136798;

public class Main {
    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        int result = 21;
        int weight = 0;

        for (int i = 0; i < number; i++) {
            int factors = countFactors(i + 1);

            weight += (factors > limit) ? power : factors;
        }

        System.out.println("answer : " + weight);

    }

    public static int countFactors(int n) {
        if (n == 1) return 1;

        int cnt = 2;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt += 2;
            }
        }

        // 제곱근이 정수인지 검사
        if (Math.sqrt(n) % 1 == 0) {
            cnt++;
        }

        return cnt;
    }
}
