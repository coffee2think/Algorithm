package programmers.lv2.nextNumber;

public class Main {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int bitCount = Integer.bitCount(n);
        int nextNumber = n+1;
        while(Integer.bitCount(nextNumber) != bitCount){
            nextNumber++;
        }
        return nextNumber;
    }
}
