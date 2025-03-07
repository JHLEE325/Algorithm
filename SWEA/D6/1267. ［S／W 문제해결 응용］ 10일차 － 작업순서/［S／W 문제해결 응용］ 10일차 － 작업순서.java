import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int V, E;
	static int[][] matrix;
	static int[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			matrix = new int[V + 1][V + 1];
			edge = new int[V + 1];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				matrix[from][to] = 1;
				edge[to]++;
			}
			ArrayList<Integer> orderList = topologySort();

			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			for (int o : orderList) {
				sb.append(o).append(" ");
			}
			System.out.println(sb);

		}
	}

	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <= V; i++) {
			if (edge[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			orderList.add(cur);

			for (int next = 1; next <= V; next++) {
				if (matrix[cur][next] == 1) {
					if (--edge[next] == 0)
						queue.offer(next);
				}
			}
		}
		return orderList;
	}

}
