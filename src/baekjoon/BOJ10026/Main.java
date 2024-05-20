package src.baekjoon.BOJ10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-20
 * source: https://www.acmicpc.net/problem/10026
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // when
        int normal = 0; // 일반인이 인식하는 구역의 수
        int blind = 0; // 적록색약이 인식하는 구역의 수

        // 일반인이 인식하는 구역 탐색
        boolean[][] visited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    dfs(x, y, map[y][x], map, visited, false);
                    normal++;
                }
            }
        }

        // 적록색약이 인식하는 구역 탐색
        visited = new boolean[N][N]; // 방문 초기화
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    dfs(x, y, map[y][x], map, visited, true);
                    blind++;
                }
            }
        }

        // then
        System.out.println(normal + " " + blind);
        br.close();
    }

    public static void dfs(int x, int y, char color, char[][] map, boolean[][] visited, boolean isBlind) {
        // map을 벗어나면 종료
        if (x < 0 || y < 0 || x >= map[0].length || y >= map.length) {
            return;
        }

        // 이미 방문했거나 색이 다르면 종료
        if (visited[y][x] || !isSameColor(map[y][x], color, isBlind)) {
            return;
        }

        // 방문 처리
        visited[y][x] = true;

        // 상하좌우 탐색
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : directions) {
            dfs(x + d[0], y + d[1], color, map, visited, isBlind);
        }
    }

    public static boolean isSameColor(char a, char b, boolean isBlind) {
        // 적록색약인 경우
        // 구분 가능한 색상이 있으면 비교하여 리턴하고
        // 그렇지 않다면(모두 구분 불가능한 색이라면) true 리턴
        if (isBlind) {
            return a == 'B' || b == 'B' ?  a == b : true;
        }

        return a == b;
    }
}
