package src.baekjoon.BOJ15686;

import java.io.*;
import java.util.*;

/**
 * date: 2024-05-06
 * source: https://www.acmicpc.net/problem/15686
 */

public class Main {
    private static int M;
    private static List<Coordinate> homeList = new ArrayList<>();
    private static List<Coordinate> chickenList = new ArrayList<>();
    private static int chickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    homeList.add(new Coordinate(x, y));
                } else if (value == 2) {
                    chickenList.add(new Coordinate(x, y));
                }
            }
        }

        // exec
        dfs(0, new ArrayList<>());

        // print result
        System.out.println(chickenDistance);
        br.close();
    }

    public static void dfs(int index, List<Coordinate> activeList) {
        if (activeList.size() == M) {
            int distanceSum = 0;

            for (Coordinate home : homeList) {
                int minDistance = Integer.MAX_VALUE;
                for (Coordinate active : activeList) {
                    int distance = calcDistance(home, active);
                    minDistance = Math.min(minDistance, distance);
                }
                distanceSum += minDistance;
            }

            // 최솟값 갱신
            chickenDistance = Math.min(chickenDistance, distanceSum);
            return;
        } else if (index >= chickenList.size()) {
            return;
        }

        // 폐업하지 않는 경우
        activeList.add(chickenList.get(index));
        dfs(index + 1, activeList);
        activeList.remove(chickenList.get(index));

        // 폐업하는 경우
        dfs(index + 1, activeList);
    }

    // 거리 계산
    public static int calcDistance(Coordinate place1, Coordinate place2) {
        return Math.abs(place1.getX() - place2.getX()) + Math.abs(place1.getY() - place2.getY());
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