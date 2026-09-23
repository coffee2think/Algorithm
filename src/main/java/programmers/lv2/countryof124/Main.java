package programmers.lv2.countryof124;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 21; i++) {
            System.out.println(i + " : " + solution(i));
        }
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = (n - 1) % 3;
            int num = (r == 0) ? 1 : (r == 1) ? 2 : 4;
            sb.insert(0, num);
            n = (n - 1) / 3;
        }

        return sb.toString();
    }
}