package src.programmers.lv2.Q77485;

import java.util.Arrays;

/**
 * Programmers Q77485 lv2
 * Problem name: 행렬 테두리 회전하기
 * link: https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */

public class Main {
    public static void main(String[] args) {
        // given
        int rows = 3;
        int columns = 3;
        int[][] queries = {
            {1,1,2,2},
            {1,2,2,3},
            {2,1,3,2},
            {2,2,3,3}
        };
        int[] answer = {1, 1, 5, 3};

        // when
        int[] result = new Main().solution(rows, columns, queries);

        // then
        System.out.println("result: " + Arrays.toString(result) + " is " + (Arrays.equals(answer, result) ? "Correct!" : "Wrong.."));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int[] answer = new int[queries.length];

        // board 초기화
        int num = 1;
        while (num <= rows * columns) {
            board[(num - 1) / columns][(num - 1) % columns] = num++;
        }

        // 쿼리 수행
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(board, queries[i]);
        }

        return answer;
    }

    public int rotate(int[][] board, int[] query) {
        // 테두리 좌표. 문제와 다르게 세로축을 y, 가로축을 x로 표현
        int y1 = query[0] - 1;
        int x1 = query[1] - 1;
        int y2 = query[2] - 1;
        int x2 = query[3] - 1;

        // 초기값
        int first = board[y1][x1];
        int min = first;

        // 테두리 회전하기. 왼쪽 변부터 회전
        int x = x1;
        int y = y1;
        int dx = 0;
        int dy = 1;

        do {
            // 위치 갱신
            x = x + dx;
            y = y + dy;

            // 시계 방향의 값 바꾸고 최솟값 갱신
            board[y - dy][x - dx] = board[y][x];
            min = Math.min(board[y][x], min);

            // 꼭짓점인 경우 방향 갱신
            if ((x == x1 || x == x2) && (y == y1 || y == y2)) {
                int ddx = dx; // dx 임시 보관 변수
                dx = (1 - Math.abs(dx)) * dy;
                dy = (1 - Math.abs(dy)) * (-ddx);
            }
        } while (x != x1 || y != y1);

        // 처음 지점으로 돌아온 경우 저장해둔 first 대입
        board[y1][x1 + 1] = first;

        return min;
    }

    public void printBoard(int[][] board) {
        System.out.println("---------------------------");
        for (int row = 0; row < board.length; row++) {
            System.out.println(Arrays.toString(board[row]));
        }
    }
}
