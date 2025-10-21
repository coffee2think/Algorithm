package src.baekjoon.BOJ14594;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// link: https://www.acmicpc.net/problem/14594
// date: 2025-10-21
// 배운점
// 1. union-find 기본 개념
// 2. union-find size 기반 최적화
// 3. union-find rank 기반 최적화
public class Main2 {
    static int[] parent;
    static int[] size;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        size = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }

        // when
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < y; j++) {
                union(j, j + 1);
            }
        }

        // then
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            uniqueRoots.add(find(i));
        }
        System.out.println(uniqueRoots.size());
        br.close();
    }

    static int find(int x) {
        return parent[x] = (parent[x] == x) ? x : find(parent[x]);
    }

    // Union by Size
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (size[x] < size[y]) {
                parent[x] = y;
                size[y] += size[x];
            } else {
                parent[y] = x;
                size[x] += size[y];
            }
        }
    }

    // Union by Rank
    static void unionByRank(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[y] = x;
                rank[x]++;
            }
        }
    }
}
