package src.programmers.lv2.Q154538;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * date: 2024-05-07
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */

public class Main {
    public static void main(String[] args) {
        // given
        int[] x = {10, 10, 2};
        int[] y = {40, 40, 5};
        int[] n = {5, 30, 4};
        int[] answer = {2, 1, -1};

        // when
        int[] result = new int[answer.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Main().solution(x[i], y[i], n[i]);
        }

        // then
        System.out.println("result: " + Arrays.toString(result) + " is " + (Arrays.equals(result, answer) ? "Correct!" : "Wrong.."));
    }

    public int solution(int x, int y, int n) {
        // bfs 활용
        Queue<int[]> q = new LinkedList<>();
        int[] visited = new int[y + 1]; // 방문 여부를 체크하고, 도달했을 때의 횟수를 저장할 배열

        q.offer(new int[]{y, 0}); // {value, count} 형식으로 넣음
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int value = cur[0];
            int count = cur[1];

            // 원하는 값에 도달하면 count를 리턴함
            if (value == x) {
                return count;
            }

            // 이미 방문한 경우 count가 크거나 같으면 패스함
            if (visited[value] != 0 && visited[value] <= count) {
                continue;
            }

            // 도달 횟수를 갱신함
            visited[value] = count;

            if (value % 3 == 0) q.offer(new int[]{value / 3, count + 1});
            if (value % 2 == 0) q.offer(new int[]{value / 2, count + 1});
            if (value - n >= x) q.offer(new int[]{value - n, count + 1});
        }

        return -1;
    }
}
