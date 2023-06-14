package programmers.jadencase;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s) {
        String lower_s = s.toLowerCase();
        char[] arr = new char[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = lower_s.charAt(i);
        }

        for (int i = 0; i < arr.length; i++) {
            if ((i == 0 || arr[i - 1] == ' ') && (arr[i] >= 'a' && arr[i] <= 'z')) {
                arr[i] += 'A' - 'a';
            }
        }

        return String.valueOf(arr);
    }
}
