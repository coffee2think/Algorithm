import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(comb(M, N) + "\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static long comb(int n, int r) {
        long result = 1;
        int sub_r = r;
        if (sub_r > n / 2) {
            sub_r = n - r;
        }

        for (int i = n; i > n - sub_r; --i) {
            result *= i;
        }
        for (int i = 1; i <= sub_r; ++i) {
            result /= i;
        }
        return result;
    }
}