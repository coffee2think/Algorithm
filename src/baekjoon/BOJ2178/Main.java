package src.baekjoon.BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 2024-04-25
 * source: https://www.acmicpc.net/problem/2178
 */

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // given
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        // when
        int moves = bfs(map);

        // then
        System.out.println(moves);
        br.close();
    }

    public static int bfs(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] moves = new int[map.length][map[0].length];
        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(0, 0));
        moves[0][0] = 1;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int y = current.getY();
            int x = current.getX();

            // 도착지점에 도달한 경우 반복문 종료
            if (y == map.length - 1 && x == map[0].length - 1) {
                break;
            }

            // 방문 처리
            visited[y][x] = true;

            // 네 방향으로 이동 가능한지 확인
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 맵에서 벗어나는 경우 무시
                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) {
                    continue;
                }

                // 이동할 수 있고 방문하지 않는 칸이라면
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.offer(new Coordinate(nx, ny));
                    visited[ny][nx] = true;
                    moves[ny][nx] = moves[y][x] + 1;
                }
            }
        }

        return moves[map.length - 1][map[0].length - 1];
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
