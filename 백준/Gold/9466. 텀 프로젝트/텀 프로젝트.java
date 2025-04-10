import java.io.*;
import java.util.*;

public class Main {

	static int n, res, cnt;
	static int[] arr;
	static boolean[] visited, cycle;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			cycle = new boolean[n + 1];
			cnt = 0;

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}
			System.out.println(n - cnt);
		}
	}

	static void dfs(int start) {
		visited[start] = true;
		int next = arr[start];
		if (!visited[next]) {
			dfs(next);
		} else if (!cycle[next]) {
			for (int i = next; i != start; i = arr[i]) {
				cnt++;
			}
			cnt++;
		}
		cycle[start] = true;
	}

}
