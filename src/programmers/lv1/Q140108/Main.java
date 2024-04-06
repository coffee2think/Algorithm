package src.programmers.lv1.Q140108;

public class Main {
    public static void main(String[] args) {
        String s = "banana";
        int result = 3;

        System.out.println((solution(s) == result) ? "테스트 통과" : "실패");
    }

    public static int solution(String s) {
        int cnt = 0;

        char first = s.charAt(0);
        int same = 0;
        int different = 0;

        for (int i = 0; i < s.length(); i++) {
            if (same == different) {
                cnt++;
                first = s.charAt(i);
            }

            if (s.charAt(i) == first) {
                same++;
            } else {
                different++;
            }
        }

        return cnt;
    }
}
