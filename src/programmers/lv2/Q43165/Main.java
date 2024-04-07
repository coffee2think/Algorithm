package src.programmers.lv2.Q43165;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{4, 1, 2, 1};
        int target = 4;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(0, numbers, 0, target);
    }

    public static int dfs(int index, int[] numbers, int sum, int target) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int cnt = 0;
        cnt += dfs(index + 1, numbers, sum + numbers[index], target);
        cnt += dfs(index + 1, numbers, sum - numbers[index], target);

        return cnt;
    }

}
