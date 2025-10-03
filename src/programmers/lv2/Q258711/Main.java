package src.programmers.lv2.Q258711;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] edges1 = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        int[][] edges2 = {
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},
                {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10},
                {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        };

        System.out.println(Arrays.toString(solution(edges1)));
        System.out.println(Arrays.toString(solution(edges2)));
    }

    public static int[] solution(int[][] edges) {
        int n = 1_000_000;
        int[][] inOut = new int[n + 1][2]; // inOut[i][0] : in, inOut[i][1] : out
        Map<Integer, HashSet<Integer>> pointMap = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            inOut[from][0]++; // 나가는 개수
            inOut[to][1]++; // 들어오는 개수
            pointMap.computeIfAbsent(from, k -> new HashSet<>()).add(to);
        }

        int generatedPoint = -1;
        for (int i = 1; i <= n; i++) {
            if (inOut[i][1] > 0) continue;
            else if (inOut[i][0] >= 2) {
                generatedPoint = i;
                break;
            }
        }

        int[] result = new int[4];
        result[0] = generatedPoint;
        for (int startingPoint: pointMap.get(generatedPoint)) {
            result[classifyGraphs(startingPoint, startingPoint, pointMap)]++;
        }

        return result;
    }

    public static int classifyGraphs(int first, int current, Map<Integer, HashSet<Integer>> pointMap) {
        // return 값 분류
        // 1 : 도넛형
        // 2 : 막대형
        // 3 : 8자형
        // -1 : 오류

        Set<Integer> nextSet = pointMap.getOrDefault(current, new HashSet<>());

        while (nextSet.size() == 1) {
            int next = nextSet.iterator().next();

            if (next == first) {
                return 1;
            }

            nextSet = pointMap.getOrDefault(next, new HashSet<>());
        }

        if (nextSet.size() == 0) {
            return 2;
        } else if (nextSet.size() == 2) {
            return 3;
        }

        return -1;
    }
}
