package src.baekjoon.BOJ14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * date: 2024-06-02
 * source: https://www.acmicpc.net/problem/14502
 */

public class Main {
    static int[][] map;
    static int maxSafeArea;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        for (int y = 0; y < height; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < width; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // solution
        buildWalls(0);

        // print result
        System.out.println(maxSafeArea);
        br.close();
    }

    // 3개의 벽 세우기. dfs 알고리즘을 이용하여 모든 경우를 완전 탐색
    public static void buildWalls(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 1;
                    buildWalls(count + 1);
                    map[y][x] = 0;
                }
            }
        }
    }

    // 바이러스 퍼뜨리기. BFS 이용
    public static void spreadVirus() {
        // 기존 map을 변형하지 않도록 map을 deep copy함
        int[][] copyMap = new int[map.length][map[0].length];
        for (int i = 0; i < copyMap.length; i++) {
            copyMap[i] = map[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();

        // 초기 바이러스 위치를 BFS 큐에 넣음
        for (int y = 0; y < copyMap.length; y++) {
            for (int x = 0; x < copyMap[0].length; x++) {
                if (copyMap[y][x] == 2) {
                    q.offer(new int[]{x, y});
                }
            }
        }

        // 바이러스 퍼뜨리기
        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= copyMap[0].length || ny >= copyMap.length) {
                    continue;
                }

                if (copyMap[ny][nx] == 0) {
                    copyMap[ny][nx] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역 크기 갱신
        maxSafeArea = Math.max(maxSafeArea, calculateSafeArea(copyMap));
    }

    // 안전 영역의 크기 세기
    public static int calculateSafeArea(int[][] map) {
        int count = 0;

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
