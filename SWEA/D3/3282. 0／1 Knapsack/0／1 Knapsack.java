import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int stuff[][] = new int[n + 1][2];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				stuff[i][1] = Integer.parseInt(st.nextToken());
				stuff[i][0] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[n + 1][m + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					if (stuff[i][1] > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stuff[i][1]] + stuff[i][0]);
					}
				}
			}

			sb.append("#" + t + " " + dp[n][m] + "\n");
		}

		System.out.println(sb);
	}
}
