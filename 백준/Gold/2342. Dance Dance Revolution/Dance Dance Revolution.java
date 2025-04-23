import java.io.*;
import java.util.*;

public class Main {

	static int[][][] dp;
	static int[] steps;
	static final int INF = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		steps = new int[100001]; // 최대 길이 10만
		int len = 0;
		while (true) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			steps[len++] = n;
		}

		dp = new int[len + 1][5][5]; // 3차원 dp 수열 길이 / 왼발 경우의수 / 오른발 경우의수
		for (int i = 0; i <= len; i++) {
			for (int l = 0; l < 5; l++) {
				Arrays.fill(dp[i][l], INF);
			}
		}

		dp[0][0][0] = 0;

		for (int i = 0; i < len; i++) {
			int next = steps[i];
			for (int l = 0; l < 5; l++) {
				for (int r = 0; r < 5; r++) {
					if (dp[i][l][r] == INF)
						continue;

					// 왼발
					dp[i + 1][next][r] = Math.min(dp[i + 1][next][r], dp[i][l][r] + cost(l, next));
					// 오른발
					dp[i + 1][l][next] = Math.min(dp[i + 1][l][next], dp[i][l][r] + cost(r, next));
				}
			}
		}

		int answer = INF;
		for (int l = 0; l < 5; l++) {
			for (int r = 0; r < 5; r++) {
				answer = Math.min(answer, dp[len][l][r]);
			}
		}

		System.out.println(answer);
	}

	static int cost(int from, int to) {
		if (from == 0)
			return 2;
		if (from == to)
			return 1;
		if (Math.abs(from - to) == 2)
			return 4;
		return 3;
	}

}
