package programmers.lv2.longJump;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        //피보나치 배열을 만들 필요도 없이(추가 메모리 공간 없이) 리턴값만 필요하다면 이런 방식도 있다.
        //피보나치 수를 여러곳에서 재사용해야한다면 배열을 이용한 방법이 좋을 듯 하다
        int answer = 0;
        int a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            answer = a + b;
            a = b;
            b = answer;
        }

        return answer;
    }

    // 1 -> 1 => 1
    // 2 -> 1,1 / 2 => 2
    // 3 -> 1,1,1 * Comb(3,0) / 1,2 * Comb(2,1) => 3
    // 4 -> 1,1,1,1 * Comb(4,0) / 1,1,2 * Comb(3,1) / 2,2 * Comb(2,2) => 5
    // 5 -> 1,1,1,1,1 * Comb(5,0) / 1,1,1,2 * Comb(4,1) / 1,2,2 * Comb(3,2) => 8
    // 6 -> 1,1,1,1,1,1 * Comb(6,0) / 1,1,1,1,2 * Comb(5,1) / 1,1,2,2 * Comb(4,2) / 2,2,2 * Comb(3,3) => 13
    // 7 -> Comb(7,0) / Comb(6,1)/ Comb(5,2) / Comb(4,3) => 1 + 6 + 10 + 4 = 21
    // => 피보나치 수열
}
