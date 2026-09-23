package baekjoon.BOJ1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon Q1939 골드3
 * Problem name: 중량제한
 * link: https://www.acmicpc.net/problem/1939
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 생성
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int weight = Integer.parseInt(br.readLine());

            map.putIfAbsent(a, new ArrayList<Edge>());
            map.putIfAbsent(b, new ArrayList<Edge>());

            map.get(a).add(new Edge(b, weight));
            map.get(b).add(new Edge(a, weight));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] minWeight = new int[N];

//        dfs(map, from, to);

        br.close();
    }

    public static void dfs() {

    }

}

class Edge {
    private int to;
    private int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}

// 다른팀 풀이
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//// 24-04-24
//// https://www.acmicpc.net/problem/1939
//public class Main {
//
//    static long max;
//    static int[][] arr;
//    static boolean[] visited;
//    static int end;
//    static int islandNum;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        islandNum = Integer.parseInt(st.nextToken());
//        int rows = Integer.parseInt(st.nextToken());
//
//        arr = new int[islandNum + 1][islandNum + 1];
//        visited = new boolean[islandNum + 1];
//        for (int i = 0; i < rows; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken());
//            int y = Integer.parseInt(st.nextToken());
//            int weight = Integer.parseInt(st.nextToken());
//            arr[x][y] = arr[y][x] = weight;
//        }
//
//        st = new StringTokenizer(br.readLine());
//        int start = Integer.parseInt(st.nextToken());
//        end = Integer.parseInt(st.nextToken());
//        // 입력 완료
//
//        visited[start] = true;
//        max = Integer.MIN_VALUE;
//        findMax(Long.MAX_VALUE, start);
//
//        System.out.println(max);
//
//    }
//
//    static void findMax(long min, int curSpot) {
//        if (curSpot == end) {
//            max = Math.max(max, min);
//        }
//
//        for (int i = 1; i <= islandNum; i++) {
//            // 한 번도 가보지 않은 곳 중, 현재 장소와 이어져 있는 곳 방문
//            if (!visited[i]
//                    && arr[curSpot][i] != 0) {
//                visited[i] = true;
//                findMax(Math.min(min, arr[curSpot][i]), i);
//                visited[i] = false;
//            }
//        }
//
//    }
//
//}

// 파이썬 A팀 코드
//# 두 개의 섬 사이의 다리마다 중량제한이 있고, 중량제한을 초과하는 물품이 지나가면 다리가 무너진다.
//# 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구해라
//
//import sys
//from collections import deque
//
//input = sys.stdin.readline
//
//def bfs(weight):
//queue = deque()
//queue.append(x)
//visited = [False] * (n+1)
//visited[x] = True
//
//while queue:
//island = queue.popleft()
//
//for i, w in graph[island]:
//# 방문하지 않았고, 이분 탐색 다리 중량 제한보다 현재 다리 w이 더 크거나 같으면 => 방문/이동 가능
//if not visited[i] and w >= weight:
//visited[i] = True # 방문처리 후 큐에 넣기
//queue.append(i)
//
//if visited[y]: return True # 마지막 종착지에 도착하면 True
//else: return False
//
//
//# 섬의 개수, 다리 개수
//n, m = map(int, input().split())
//graph = [[] for _ in range(n+1)]
//
//for i in range(m):
//# a번 섬, b번 섬, 중량제한 c
//a, b, c = map(int, input().split())
//graph[a].append([b, c])
//graph[b].append([a, c]) # 양방향 그래프, 인접 리스트
//
//# 공장 위치
//x, y = map(int, input().split())
//
//# 이분 탐색
//start = 1
//end = 10000000000 # C(1 ≤ C ≤ 1,000,000,000) 다리 중량 제한의 최댓값
//
//result = 0
//while start <= end: # start가 end보다 작거나 같으면 중지
//mid = (start + end) // 2
//
//if bfs(mid): # y 목적지에 도착했으면
//result = mid
//start = mid + 1
//
//else: # 현재 주어진 다리 중량 제한들보다 이분 탐색 다리 제한이 클 경우 줄이기
//end = mid - 1
//
//print(result)

// 파이썬 멘토님 코드
//from collections import defaultdict
//import sys
//
//sys.stdin = open("input.txt", "r")
//input = sys.stdin.readline
//
//
//def input_data():
//N, M = map(int, input().split())
//graph = defaultdict(list)
//max_weight = 0
//for _ in range(M):
//A, B, C = map(int, input().split())
//graph[A].append((B, C))
//graph[B].append((A, C))
//max_weight = max(max_weight, C)
//
//from_island, to_island = map(int, input().split())
//return graph, from_island, to_island, max_weight
//
//def can_visit(limit, graph, island1, island2):
//visited = set()
//stack = [island1]
//while stack:
//now = stack.pop()
//if now == island2:
//return True
//visited.add(now)
//for goal, cost in graph[now]:
//if cost < limit or goal in visited:
//continue
//stack.append(goal)
//return False
//
//def binary_search(graph, from_island, to_island, max_weight):
//start, end = 1, max_weight
//while end >= start:
//mid = (start + end) // 2
//data = can_visit(mid, graph, from_island, to_island)
//if data:
//start = mid + 1
//else:
//end = mid - 1
//
//return end
//
//def solution():
//graph, from_island, to_island, max_weight = input_data()
//
//return binary_search(graph, from_island, to_island, max_weight)
//
//
//if __name__ == "__main__":
//print(solution())
