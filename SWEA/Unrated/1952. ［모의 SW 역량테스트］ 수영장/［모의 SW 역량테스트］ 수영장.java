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
			int[] price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int[] month = new int[13];
			for (int i = 1; i < 13; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[13];
			for (int i = 1; i < 13; i++) {
				int cost1 = Math.min(dp[i - 1] + price[0] * month[i], dp[i - 1] + price[1]);
				int cost2 = price[2];
				if (i >= 3) {
					cost2 = dp[i - 3] + price[2];
				}

				dp[i] = Math.min(cost1, cost2);
			}

			sb.append("#" + t + " " + Math.min(dp[12], price[3]) + "\n");
		}
		System.out.println(sb);
	}
}
