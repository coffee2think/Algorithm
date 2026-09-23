package baekjoon.BOJ18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * date: 2024-05-29
 * source: https://www.acmicpc.net/problem/18352
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 목표 거리
        int X = Integer.parseInt(st.nextToken()); // 출발 지점
        Node[] nodes = new Node[N]; // 도시 목록
        Edge[] edges = new Edge[M]; // 도로 목록
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[m] = new Edge(from, to);
        }

        // solution


        // print result

        br.close();
    }
}

class Node {
    private int index;
    private List<Edge> connected;

    public Node(int index) {
        this.index = index;
    }

    public void addEdge(Edge edge) {
        if (connected == null) {
            connected = new ArrayList<>();
        }

        connected.add(edge);
    }
}

class Edge {
    private int from;
    private int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}