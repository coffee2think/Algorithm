package src.baekjoon.BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * date: 2024.04.25
 * source: https://www.acmicpc.net/problem/1260
 */

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.addEdge(a, b);
        }

        dfs(graph, V);
        sb.append("\n");
        bfs(graph, V);

        System.out.println(sb);
        br.close();
    }

    public static void dfs(Graph graph, int start) {
        boolean[] visited = new boolean[graph.size() + 1];
        dfs(graph, start, visited);
    }

    public static void dfs(Graph graph, int start, boolean[] visited) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int adj : graph.getAdjSet(start)) {
            if (!visited[adj]) {
                dfs(graph, adj, visited);
            }
        }
    }

    public static void bfs(Graph graph, int start) {
        boolean[] visited = new boolean[graph.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int adj : graph.getAdjSet(current)) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }
}

class Graph {
    private final List<Set<Integer>> adjSet;

    public Graph(int N) {
        adjSet = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adjSet.add(new TreeSet<>());
        }
    }

    public void addEdge(int a, int b) {
        adjSet.get(a).add(b);
        adjSet.get(b).add(a);
    }

    public Set<Integer> getAdjSet(int a) {
        return adjSet.get(a);
    }

    public int size() {
        return adjSet.size() - 1;
    }
}
