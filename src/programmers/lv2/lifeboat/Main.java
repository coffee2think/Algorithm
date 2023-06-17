package lifeboat;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] people = new int[]{70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));

    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0, r = people.length - 1;
        int cnt = 0;

        while(l < r){
            if(people[r] + people[l] > limit){
                r--;
                cnt++;
            } else if(people[r] + people[l] <= limit){
                l++;
                r--;
                cnt++;
            }
        }
        if(l == r) cnt++;
        return cnt;
    }
}
