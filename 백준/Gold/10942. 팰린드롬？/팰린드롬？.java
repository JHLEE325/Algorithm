import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i < n; i++) {
			dp[i][i] = 1;
			if (arr[i] == arr[i + 1])
				dp[i][i + 1] = 1;
		}
		dp[n][n] = 1;

		for (int len = 3; len <= n; len++) {
			for (int i = 1; i <= n - len + 1; i++) {
				int j = i + len - 1;
				if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1)
					dp[i][j] = 1;
			}
		}

		int cnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s][e]+"\n");
		}
		
		System.out.println(sb);

	}

}
