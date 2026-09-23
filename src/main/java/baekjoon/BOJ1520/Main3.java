package baekjoon.BOJ1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        long before = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
//        int height = Integer.parseInt(st.nextToken());
//        int width = Integer.parseInt(st.nextToken());
        int height = 500;
        int width = 500;
        int[][] map = new int[height][width];
        for (int y = 0; y < height; y++) {
//            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < width; x++) {
//                map[y][x] = Integer.parseInt(st.nextToken());
                map[y][x] = (height - y) * (width - x);
            }
        }

        // when
        int[][] count = new int[height][width];
        count[height - 1][width - 1] = 1;
        int result = countPaths(0, 0, map, count);

        // then
        System.out.println(result);
        br.close();

        long after = System.currentTimeMillis();
        System.out.printf("time: %d ms\n", after - before);
        System.out.printf("methodCount: %d, updateCount: %d\n", methodCount, updateCount);
    }

    private static int methodCount = 0;
    private static int updateCount = 0;
    public static int countPaths(int x, int y, int[][] map, int[][] count) {
//        System.out.printf("methodCount: %d, x: %d, y: %d\n", ++methodCount, x, y);
        methodCount++;
        // 이미 기록된 값이 있으면
        if (count[y][x] > 0) {
            return count[y][x];
        }

        // 기록된 값이 없는 경우 상하좌우 탐색
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // map을 벗어나면 스킵
            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            // 현 위치보다 낮은 지역의 경우의 수를 모두 합함
            if (map[ny][nx] < map[y][x]) {
                count[y][x] += countPaths(nx, ny, map, count);
//                System.out.printf("updateCount: %d, nx: %d, ny: %d, count[%d][%d] = %d\n", ++updateCount, nx, ny, y, x, count[y][x]);
                updateCount++;
            }
        }

        return count[y][x];
    }
}
