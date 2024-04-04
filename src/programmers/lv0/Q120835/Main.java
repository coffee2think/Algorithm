package src.programmers.lv0.Q120835;

import java.util.Arrays;

public class Main {
    public int[] solution(int[] emergency) {
        Emergency[] arr = new Emergency[emergency.length];
        int[] answer = new int[emergency.length];

        for (int i = 0; i < emergency.length; ++i) {
            arr[i] = new Emergency(i, emergency[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            answer[arr[i].getIdx()] = i + 1;
        }

        return answer;
    }

    class Emergency implements Comparable<Emergency> {
        private int idx;
        private int val;

        public Emergency (int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int getIdx() {
            return idx;
        }

        public int getVal() {
            return val;
        }

        @Override
        public int compareTo(Emergency other) {
            return other.getVal() - this.getVal(); // 내림차순 정렬
        }
    }
}
