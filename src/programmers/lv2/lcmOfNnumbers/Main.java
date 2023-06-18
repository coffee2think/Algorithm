package programmers.lv2.lcmOfNnumbers;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 8, 14};

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm * arr[i] / gcd(lcm, arr[i]);
        }
        return lcm;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
