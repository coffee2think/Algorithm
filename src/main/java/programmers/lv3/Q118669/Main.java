package programmers.lv3.Q118669;

import java.util.*;

public class Main {
    public static boolean[] visited;


    public static void main(String[] args) {

    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        visited = new boolean[n];
        int minIntensity = -1;

        return null;
    }

    class GraphNode {
        int val;
        List<GraphNode> neighbors;

        public GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void dfs(GraphNode start) {
        if (start == null)
            return;

        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.poll();

            for (GraphNode neighbor : currNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }


}
