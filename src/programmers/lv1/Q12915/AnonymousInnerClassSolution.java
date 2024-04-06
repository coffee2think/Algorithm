package src.programmers.lv1.Q12915;

import java.util.Arrays;
import java.util.Comparator;

public class AnonymousInnerClassSolution {
    public String[] solution(String[] strings, int n, int size) {
        String[] copyArray = new String[size];
        System.arraycopy(strings, 0, copyArray, 0, size);

        Arrays.sort(copyArray, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }

                return s1.charAt(n) - s2.charAt(n);
            }
        });

        return copyArray;
    }
}
