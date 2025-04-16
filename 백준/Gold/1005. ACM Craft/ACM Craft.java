import java.io.*;
import java.util.*;

public class Main {

	static int n, k, res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			res = 0;
			int[] arr = new int[n];
			int[] temparr = new int[n];
			int[] indegree = new int[n];
			List<List<Integer>> list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(new ArrayList<>());
				arr[i] = Integer.parseInt(st.nextToken());
				temparr[i] = arr[i];
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				list.get(x - 1).add(y - 1);
				indegree[y - 1]++;
			}

			Queue<Integer> q = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				if (indegree[i] == 0)
					q.add(i);
			}

			while (!q.isEmpty()) {
				int size = q.size();
				int temp = 0;
				for (int s = 0; s < size; s++) {
					int cur = q.poll();

					for (int next : list.get(cur)) {
						if (--indegree[next] == 0) {
							q.add(next);
						}
						temparr[next] = Math.max(temparr[next], +temparr[cur] + arr[next]);
					}
				}
			}
			int goal = Integer.parseInt(br.readLine());
			res = temparr[goal - 1];

			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

}
