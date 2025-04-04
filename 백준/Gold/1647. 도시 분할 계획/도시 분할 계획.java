import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.weight - o.weight;
		}

	}

	static Edge[] edgeList;
	static int[] parents;
	static int V, E, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];
		parents = new int[V + 1];

		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(from, to, w);
		}

		Arrays.sort(edgeList);

		long result = 0, count = 0;

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				max = edge.weight;
				if (++count == V - 1) {
					break;
				}
			}
		}

		System.out.println(result - max);
	}

	static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);

		if (aroot == broot)
			return false;

		parents[broot] = aroot;
		return true;
	}
}
