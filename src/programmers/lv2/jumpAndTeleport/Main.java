package programmers.jumpAndTeleport;

public class Main {
    public static void main(String[] args) {
        int n = 5000;
        System.out.println("answer = " + solution(n));
    }

    public static int solution(int n) {
        if (n == 1) return 1;

        if (n % 2 == 0) return solution(n / 2);
        else return solution(n - 1) + 1;
    }
}
