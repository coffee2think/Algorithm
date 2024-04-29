import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        
        for (int n = 1; n <= len; n++) {
            for (int start = 0; start < len; start++) {
                int sum = 0, j = n;
                while (j-- > 0) {
                    sum += elements[(start + j) % len];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}