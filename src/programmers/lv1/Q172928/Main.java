package src.programmers.lv1.Q172928;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Programmers Q172928 lv1
 * Problem name: 공원 산책
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */

public class Main {
    public static void main(String[] args) {
        String[] park = {"OXXO", "XSXO", "XXXX"};
        String[] routes = {"E 1", "S 1"};
        int[] answer = {1, 1};

        int[] result = new Main().solution(park, routes);

        System.out.println("result: " + Arrays.toString(result));
        System.out.println(Arrays.equals(answer, result) ? "Correct!" : "Wrong..");

    }

    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;

        // 시작 위치 찾기
        findingStartLoop:
        for (int row = 0; row < park.length; row++) {
            for (int col = 0; col < park[row].length(); col++) {
                if (park[row].charAt(col) == 'S') {
                    y = row;
                    x = col;
                    break findingStartLoop;
                }
            }
        }

        loop:
        for (int i = 0; i < routes.length; i++) {
            StringTokenizer st = new StringTokenizer(routes[i]);
            char direction = st.nextToken().charAt(0);
            int distance = Integer.parseInt(st.nextToken());

            int dx = 0;
            int dy = 0;

            // 방향 결정
            switch (direction) {
                case 'E': dx = 1; break;
                case 'W': dx = -1; break;
                case 'S': dy = 1; break;
                case 'N': dy = -1; break;
            }

            // 이동 위치가 범위를 벗어날 경우 명령을 무시함
            int destX = x + dx * distance;
            int destY = y + dy * distance;
            if ((destY < 0 || destY >= park.length) || (destX < 0 || destX >= park[0].length())) {
                continue;
            }

            // 중간에 장애물이 있을 경우 명령을 무시함
            for (int j = 1; j <= distance; j++) {
                if (park[y + dy * j].charAt(x + dx * j) == 'X') {
                    continue loop;
                }
            }

            // 명령이 올바를 경우 위치 갱신
            x = destX;
            y = destY;
        }

        return new int[]{y, x};
    }


}
