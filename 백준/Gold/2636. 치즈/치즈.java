import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] grid;
	static boolean[][] visited;
	static int N, M, ans, cheese;

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new boolean[N][M];
			boolean finish = true;
			cheese=0;
			ans++;
			bfs(0, 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] && grid[i][j] == 1) {
						grid[i][j] = 0;
						visited[i][j] = false;
					}
					if (!visited[i][j] && grid[i][j] == 1) {
						finish = false;
					}
				}
			}
			if(finish)break;
		}
		System.out.println(ans);
		System.out.println(cheese);
	}

	public static void bfs(int starty, int startx) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[starty][startx] = true;
		queue.offer(new int[] { starty, startx });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (grid[cur[0]][cur[1]] == 1) {
				cheese++;
			}

			else if (grid[cur[0]][cur[1]] == 0) {
				for (int k = 0; k < 4; k++) {
					int dy = cur[0] + dir[k][0];
					int dx = cur[1] + dir[k][1];

					if (dy >= 0 && dy < N && dx >= 0 && dx < M && !visited[dy][dx]) {
						visited[dy][dx] = true;
						queue.offer(new int[] { dy, dx });
					}
				}
			}
		}
	}
}
