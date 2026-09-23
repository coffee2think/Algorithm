package programmers.lv2.tiling2n;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int n1 = 0, n2 = 1;

        for(int i=0; i<n; i++){
            int tmp = n1 + n2;
            n1 = n2;
            n2 = tmp;
        }

        return n2;
    }
}
