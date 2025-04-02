import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int y, x, weight;

		public Node(int y, int x, int weight) {
			super();
			this.y = y;
			this.x = x;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	static int[][] map, cmap;
	static boolean[][] visited;
	static int n, m;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			cmap = new int[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j) - '0';
					cmap[i][j] = Integer.MAX_VALUE/2;
				}
			}

			dijkstra();
			
			System.out.println(cmap[n-1][m-1]);
	}

	static void dijkstra() {
		cmap[0][0] = map[0][0];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, cmap[0][0]));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.y][cur.x])
				continue;
			visited[cur.y][cur.x] = true;

			for (int i = 0; i < 4; i++) {
				int dy = cur.y + dir[i][0];
				int dx = cur.x + dir[i][1];

				if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
					if (cmap[dy][dx] > cmap[cur.y][cur.x] + map[dy][dx]) {
						cmap[dy][dx] = cmap[cur.y][cur.x] + map[dy][dx];
						pq.add(new Node(dy, dx, cmap[dy][dx]));
					}
				}
			}
		}
	}

}
