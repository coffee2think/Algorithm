package src.programmers.lv2.Q86971;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Programmers Q86971 lv2
 * Problem name: 전력망을 둘로 나누기
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */

public class Main {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int answer = 3;

        long before1 = System.nanoTime();
        int result1 = new Main().solution1(n, wires);
        System.out.println("solution1 result : " + result1);
        System.out.println(result1 == answer ? "Correct!" : "Wrong..");
        long after1 = System.nanoTime();

        long before2 = System.nanoTime();
        int result2 = new Main().solution2(n, wires);
        System.out.println("solution2 result : " + result2);
        System.out.println(result2 == answer ? "Correct!" : "Wrong..");
        long after2 = System.nanoTime();

        System.out.println("solution1 time : " + (after1 - before1) + "ns");
        System.out.println("solution2 time : " + (after2 - before2) + "ns");
    }

    // Union-Find를 이용한 방법
    public int solution1(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int[] parent = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            int a = wires[i][0];
            int b = wires[i][1];

            for (int j = 0; j < wires.length; j++) {
                if (j == i) continue;

                union(parent, wires[j][0], wires[j][1]);
            }

            int cntA = 0;
            for (int j = 1; j <= n; j++) {
                if (parent[j] == parent[a]) {
                    cntA++;
                }
            }

            minDiff = Math.min(Math.abs(n - 2 * cntA), minDiff);
            System.out.println("parent: " + Arrays.toString(parent) + ", cntA : " + cntA + ", minDiff : " + minDiff);
        }

        return minDiff;
    }

    public void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int find(int[] parent, int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent, parent[a]);
    }

    // DFS를 이용한 방법
    public int solution2(int n, int[][] wires) {
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        buildGraph(nodes, wires);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            nodes[a].children.remove(nodes[b]);
            nodes[b].children.remove(nodes[a]);

            int cntA = dfs(nodes, a, new boolean[n + 1]);
            int cntB = n - cntA;

            minDiff = Math.min(Math.abs(cntA - cntB), minDiff);

            nodes[a].addChild(nodes[b]);
            nodes[b].addChild(nodes[a]);
        }

        return minDiff;
    }

    public class Node {
        int num;
        List<Node> children = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }

        public void addChild(Node child) {
            children.add(child);
        }
    }

    public void buildGraph(Node[] nodes, int[][] wires) {
        for (int[] wire : wires) {
            nodes[wire[0]].addChild(nodes[wire[1]]);
            nodes[wire[1]].addChild(nodes[wire[0]]);
        }
    }

    public int dfs(Node[] nodes, int start, boolean[] visited) {
        visited[start] = true;

        int cnt = 1;
        for (Node child : nodes[start].children) {
            if (!visited[child.num]) {
                cnt += dfs(nodes, child.num, visited);
            }
        }

        return cnt;
    }
}
