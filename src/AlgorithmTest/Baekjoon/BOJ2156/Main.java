package BOJ2156;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] wine = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		int[] manyWine = new int[wine.length];
		manyWine[1] = wine[1];
		if (n > 1) manyWine[2] = manyWine[1] + wine[2];
		for (int i = 3; i < wine.length; i++) {
			manyWine[i] = Math.max(manyWine[i - 2], manyWine[i - 3] + wine[i - 1]) + wine[i];
		}

		System.out.println(Math.max(manyWine[n - 1], manyWine[n]));
		br.close();
	}
}
