package AlgorithmTest.Baekjoon.BOJ14889;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static int[] startTeam;
    static int[] linkTeam;
    static int min = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                S[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        startTeam = new int[N / 2];
        linkTeam = new int[N / 2];
        organizeTeam(startTeam, 1, 0);

        System.out.println(min);
        br.close();
    }

    public static void organizeTeam(int[] startTeam, int nextPlayer, int depth) {
        if (depth == N / 2) {
            int[] teamPerformance = calcPerformance(startTeam);
            int startTeamPerformance = teamPerformance[0];
            int linkTeamPerformance = teamPerformance[1];

            int diff = Math.abs(startTeamPerformance - linkTeamPerformance);
            if (min == -1) min = diff;
            else min = Math.min(min, diff);
            return;
        }

        for (int player = nextPlayer; player <= N; player++) {
            startTeam[depth] = player;
            organizeTeam(startTeam, player + 1, depth + 1);
            startTeam[depth] = 0;
        }
    }

    public static int[] calcPerformance(int[] startTeam) {
        int[] teamPerformance = new int[2];

        int startIdx = 0;
        int linkIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (startIdx >= N / 2 || i != startTeam[startIdx]) {
                linkTeam[linkIdx++] = i;
            } else {
                startIdx++;
            }
        }

        for (int i = 0; i < N / 2 - 1; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int startPlayer1 = startTeam[i] - 1;
                int startPlayer2 = startTeam[j] - 1;
                int linkPlayer1 = linkTeam[i] - 1;
                int linkPlayer2 = linkTeam[j] - 1;
                teamPerformance[0] += S[startPlayer1][startPlayer2] + S[startPlayer2][startPlayer1];
                teamPerformance[1] += S[linkPlayer1][linkPlayer2] + S[linkPlayer2][linkPlayer1];
            }
        }

        return teamPerformance;
    }
}
