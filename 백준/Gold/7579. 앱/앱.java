import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int limit = 0;

		int[][] apps = new int[n + 1][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			apps[i][0] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			apps[i][1] = Integer.parseInt(st.nextToken());
			limit += apps[i][1];
		}

		int[][] dp = new int[n + 1][limit + 1];

		for (int appno = 1; appno <= n; appno++) {
			for (int cost = 0; cost <= limit; cost++) {
				if (cost < apps[appno][1])
					dp[appno][cost] = dp[appno - 1][cost];
				else {
					dp[appno][cost] = Math.max(dp[appno - 1][cost], dp[appno - 1][cost - apps[appno][1]] + apps[appno][0]);
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int j = 0; j <= limit; j++) {
			if (dp[n][j] >= m) {
				answer = Math.min(answer, j);
			}
		}
		System.out.println(answer);
	}
}
