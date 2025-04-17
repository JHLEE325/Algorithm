import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] indegree = new int[n];
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
			indegree[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			graph.get(from).add(to);
			indegree[to]++;
		}

		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append((cur+1) + " ");
			
			for(int next : graph.get(cur)) {
				if(--indegree[next]==0)
					q.add(next);
			}
		}
		
		System.out.println(sb);
	}
}
