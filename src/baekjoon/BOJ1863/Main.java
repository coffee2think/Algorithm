package src.baekjoon.BOJ1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Baekjoon Q1863 골드4
 * Problem name: 스카이라인 쉬운거
 * link: https://www.acmicpc.net/problem/1863
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cnt = 0; // 건물 개수 카운트

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 현재 건물보다 높은 건물들을 스택에서 제거
            while(!stack.isEmpty() && y < stack.peek()) {
                stack.pop();
            }

            if (y != 0 && (stack.isEmpty() || y > stack.peek())) { // 스택이 비었거나, 스택이 비지 않고 높이가 증가한다면
                // 높이가 증가하면 새로운 건물이 생겼음을 의미
                stack.push(y);
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}

// 파이썬 A님 코드
//'''
//skyline 높이 h가 이전보다 낮아졌을 때
//만약 과거에 h와 동일한 높이가 존재했을 경우 answer를 추가하지 않아도 됨
//
//따라서 h가 이전 높이보다 높아지면 answer += 1
//h가 이전 높이보다 낮아지면 그 사이의 값들을 스택에서 제거한 후,
//h와 동일한 높이가 스택에 존재하지 않았다면 answer += 1
//반복
//'''
//import sys
//
//n = int(sys.stdin.readline())
//
//skyline = []
//for i in range(n):
//skyline.append(list(map(int, sys.stdin.readline().split())))
//
//has_height = [0] # stack
//
//answer = 0
//for idx, h in skyline:
//if has_height[-1] < h:
//answer += 1
//has_height.append(h)
//else:
//while has_height[-1] > h:
//has_height.pop()
//
//if has_height[-1] < h:
//answer += 1
//has_height.append(h)
//
//print(answer)

// 파이썬 B팀 코드
//'''
//스택을 활용
//x 좌표를 기준으로 오름차순 정렬
//처음에 0을 넣고 시작해서 빈 스택의 top값을 참조하는 것 방지
//참고하는 y좌표의 값이 스택의 top 보다 크면 스택에 그 값을 넣고 넘어간다.
//y좌표 값이 스택의 값보다 작으면 스택을 계속 pop 하는 것과 동시에 건물 수 증가
//pop을 다 진행한 후 y값이 더 크면 스택에 추가
//
//마지막에 처음 넣은 0을 제외하고 스택에 남은 y좌표들을 건물 수에 더한다.
//'''
//import sys
//input = sys.stdin.readline
//
//n = int(input())
//pos = []
//for _ in range(n):
//x, y = map(int, input().split())
//pos.append((x, y))
//pos.sort()
//cnt = 0
//stack = [0]
//for x, y in pos:
//if stack[-1] < y:
//stack.append(y)
//continue
//while stack[-1] > y:
//stack.pop()
//cnt += 1
//if stack[-1] < y:
//stack.append(y)
//cnt += len(stack)-1
//print(cnt)

// 파이썬 멘토님 코드
//def solution():
//    n = int(input())
//    stack = []
//    count = 0
//    for _ in range(n):
//    x, y = map(int, input().split())
//
//    if not stack:
//    stack.append(y)
//    continue
//
//    while stack and stack[-1] > y:
//    count += 1
//    stack.pop()
//
//    if not stack or stack[-1] != y:
//    stack.append(y)
//
//    while stack:
//    if stack[-1] != 0:
//    count += 1
//    stack.pop()
//
//    return count
//
//    if **name** == "**main**":
//    print(solution())