package programmers.lv2.selectTangerine;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int k = (int) (Math.random() * 100000 + 1);
        int k = 100000;
        int size = 100000;
        int[] tangerine = new int[size];
        for (int i = 0; i < size; i++) {
//            tangerine[i] = (int) (Math.random() * 100000 + 1);
            tangerine[i] = i;
        }
//        int[] tangerine = new int[]{1, 3, 2, 5, 4, 5, 2, 3};

        long beforeTime = System.currentTimeMillis();
        System.out.println("k = " + k);
        System.out.println(solution(k, tangerine));
        long afterTime = System.currentTimeMillis();
        System.out.println("Working Time : " + (afterTime - beforeTime));
    }

    public static int solution(int k, int[] tangerine) {
        List<Tangerine> list = new ArrayList<>();

        for (int i = 0; i < tangerine.length; i++) {
            int size = tangerine[i];
            boolean found = false;

            for (Tangerine item : list) {
                if (item.size == size) {
                    item.count++;
                    found = true;
                    break;
                }
            }
            if (!found) list.add(new Tangerine(size));
        }

        Collections.sort(list, new Comparator<Tangerine>() {
            @Override
            public int compare(Tangerine o1, Tangerine o2) {
                if (o1.count != o2.count) {
                    return o2.count - o1.count; // 빈도수 내림차순 정렬
                } else {
                    return o2.size - o1.size; // 크기 내림차순 정렬
                }
            }
        });

        int total = k;
        int kind = 0;
        while (total > 0 && kind < list.size()) {
            total -= list.get(kind++).count;
        }

        return kind;
    }

    public static class Tangerine {
        int size;
        int count = 1;

        public Tangerine(int size) {
            this.size = size;
        }
    }
}
