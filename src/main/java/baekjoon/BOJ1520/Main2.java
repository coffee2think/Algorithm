package baekjoon.BOJ1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    private static int count = 0;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        long before = System.nanoTime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
//        int height = Integer.parseInt(st.nextToken());
//        int width = Integer.parseInt(st.nextToken());
        int height = 10;
        int width = 10;
        int[][] map = new int[height][width];
        for (int y = 0; y < height; y++) {
//            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < width; x++) {
//                map[y][x] = Integer.parseInt(st.nextToken());
                map[y][x] = (height - y) * (width - x);
            }
        }

        System.out.println("------------< Map > ------------");
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }

        // dfs 수행
        boolean[][] visited = new boolean[height][width];
        visited[0][0] = true;
        dfs(0, 0, map, visited);
        visited[0][0] = false;

        // then
        System.out.println(count);
        br.close();

        long after = System.nanoTime();
        System.out.println("time: " + (after - before) / 1000 + "ms");
    }

    public static void dfs (int x, int y, int[][] map, boolean[][] visited) {
        // 목표 지점에 도착하면 카운트 증가
        if (y == map.length - 1 && x == map[0].length - 1) {
            count++;
            System.out.println("count: " + count);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // map을 벗어나면
            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            // 다음 지역이 방문하지 않았고 높이가 낮아지면 계속 진행
            if (!visited[ny][nx] && map[ny][nx] < map[y][x]) {
                visited[ny][nx] = true;
                dfs(nx, ny, map, visited);
                visited[ny][nx] = false;
            }
        }
    }
}