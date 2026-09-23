package baekjoon.BOJ13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * date: 2024-06-03
 * source: https://www.acmicpc.net/problem/13460
 */

public class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static Marble red;
    static Marble blue;
    static Marble hole;
    static char[][] map;
    static int minMove = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        map = new char[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 'R') {
                    red = new Marble(j, i, 'R');
                } else if (map[i][j] == 'B') {
                    blue = new Marble(j, i, 'B');
                } else if (map[i][j] == 'O') {
                    hole = new Marble(j, i, 'O');
                }
            }
        }

        // solution
        dfs(1);

        // print result
        System.out.println(minMove > 10 ? -1 : minMove);
        br.close();
    }

    public static void dfs(int count) {
        // 10회를 초과하거나 최소 횟수보다 많이 이동하면 종료
        if (count > Math.min(minMove, 10)) {
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int moveResult = moveMarble(dx[i], dy[i], count);

            if (moveResult == 1) {
                // 빨간 구슬이 구멍에 도착했을 경우 최소 횟수를 갱신함
                minMove = Math.min(minMove, count);
                return;
            } else if (moveResult == 0) {
                // 이동 가능하면 계속 진행함
                dfs(count + 1);

                // 이전 위치 복원
                red.x = red.prevX[count];
                red.y = red.prevY[count];
                blue.x = blue.prevX[count];
                blue.y = blue.prevY[count];
            }
        }
    }

    // -1 : 이동 불가능
    // 0 : 이동 가능. 이동 처리
    // 1 : 빨간 구슬이 구멍에 도착함
    public static int moveMarble(int dx, int dy, int count) {
        int newRedX = moveX(red.x + dx);
        int newRedY = moveY(red.y + dy);
        int newBlueX = moveX(blue.x + dx);
        int newBlueY = moveY(blue.y + dy);

        int moveCount = 1;
        while (true) {
            if (newRedX == newBlueX && newRedY == newBlueY) {
                break;
            }

        }

        // 위치가 같으면 이동할 수 없음
        if (newRedX == newBlueX && newRedY == newBlueY) {
            return -1;
        }

        // 파란 구슬이 구멍으로 들어가면 안됨
        if (newBlueX == hole.x && newBlueY == hole.y) {
            return -1;
        }

        // 빨간 구슬이 구멍에 도착
        if (newRedX == hole.x && newRedY == hole.y) {
            return 1;
        }

        red.prevX[count - 1] = red.x;
        red.prevY[count - 1] = red.y;
        blue.prevX[count - 1] = blue.x;
        blue.prevY[count - 1] = blue.y;

        red.x = newRedX;
        red.y = newRedY;
        blue.x = newBlueX;
        blue.y = newBlueY;
        return 0;
    }

    public static int moveX(int x) {
        // 벽에 부딪힐 경우
        if (x <= 0) {
            return 1;
        } else if (x >= map[0].length - 1) {
            return map[0].length - 2;
        }

        return x;
    }

    public static int moveY(int y) {
        // 벽에 부딪힐 경우
        if (y <= 0) {
            return 1;
        } else if (y >= map.length - 1) {
            return map.length - 2;
        }

        return y;
    }

    static class Marble {
        int x, y;
        int[] prevX = new int[11];
        int[] prevY = new int[11];
        char symbol;

        public Marble(int x, int y, char symbol) {
            this.x = x;
            this.y = y;
            this.symbol = symbol;
        }
    }
}
