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
			int maxcal = Integer.parseInt(st.nextToken());
			int[] flavors = new int[n];
			int[] calories = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				flavors[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[n + 1][maxcal + 1];

			for (int i = 1; i <= n; i++) {
				for (int c = 0; c <= maxcal; c++) {
					if (calories[i - 1] > c) {
						dp[i][c] = dp[i - 1][c];
					} else {
						dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - calories[i - 1]] + flavors[i - 1]);
					}
				}
			}

			sb.append("#" + t + " " + dp[n][maxcal] + "\n");
		}
		System.out.println(sb);
	}
}
