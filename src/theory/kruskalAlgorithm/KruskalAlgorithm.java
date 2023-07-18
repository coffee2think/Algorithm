package theory.KruskalAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 6},
                {1, 3, 3},
                {1, 4, 1},
                {2, 5, 4},
                {3, 4, 2},
                {3, 5, 5},
                {4, 5, 7}
        };

        int[] parent = new int[6]; // vertex는 1~5까지 있음. index와 vertex번호를 맞추기 위해 크기를 +1 함
        for(int i = 1; i < parent.length; i++) parent[i] = i; // 루트 노드를 자기 자신으로 설정

        int total = 0; // MST의 가중치 총합

        // 가중치를 기준으로 그래프 오름차순 정렬 → 그리디 접근
        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i = 0; i < graph.length; i++){
            if(find(parent, graph[i][0]) != find(parent, graph[i][1])){
                total += graph[i][2];
                union(parent, graph[i][0], graph[i][1]);
            }
        }

        System.out.println("MST의 최소 비용 : " + total);
    }

    public static void union(int[] parent, int a, int b){
        int parentOf_a = find(parent, a);
        int parentOf_b = find(parent, b);

        if(parentOf_a < parentOf_b)
            parent[parentOf_b] = parentOf_a;
        else
            parent[parentOf_a] = parentOf_b;
    }

    public static int find(int[] parent, int i){
        if(parent[i] == i)
            return i;

        return find(parent, parent[i]);
    }
}