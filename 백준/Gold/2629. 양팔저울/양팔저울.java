import java.io.*;
import java.util.*;

public class Main {

	static int n, m, res;
	static int[] w;
	static boolean[][] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		w = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}

		m = Integer.parseInt(br.readLine());
		chk = new boolean[n + 1][15001];

		dfs(0, 0);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			res = Integer.parseInt(st.nextToken());
			if (res > 15001) {
				sb.append("N ");
				continue;
			}
			if (chk[n][res])
				sb.append("Y ");
			else
				sb.append("N ");
		}
		System.out.println(sb);
	}

	static void dfs(int cnt, int weight) {
		if (cnt > n || weight < 0 || weight > 15001 || chk[cnt][weight])
			return;

		chk[cnt][weight] = true;

		if (cnt == n)
			return;

		dfs(cnt + 1, weight + w[cnt]);
		dfs(cnt + 1, weight);
		dfs(cnt + 1, Math.abs(weight - w[cnt]));
	}
}
