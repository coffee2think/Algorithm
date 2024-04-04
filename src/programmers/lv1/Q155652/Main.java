package src.programmers.lv1.Q155652;

public class Main {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyz".replaceAll("[" + skip + "]", "");
        char[] letterArr = letters.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            sb.append(letterArr[(letters.indexOf(s.charAt(i)) + index) % letterArr.length]);
        }

        return sb.toString();
    }
}
