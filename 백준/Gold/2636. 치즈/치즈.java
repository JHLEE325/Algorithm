import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] grid; // 치즈 맵
	static boolean[][] visited; // 방문 확인
	static int N, M, ans, cheese;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 4방탐색용

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
			boolean finish = true; // 치즈가 완전히 없어졌는지 확인
			cheese = 0; // 각 시행별 남은 치즈 확인용
			ans++; // 시행횟수
			bfs(0, 0); // bfs 수행
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == 1) { // 없어지지 않은 치즈 있는지 확인
						finish = false;
					}
				}
			}
			if (finish)
				break; // 없어지지 않은 치즈가 없으면 종료
		}
		System.out.println(ans);
		System.out.println(cheese);
	}

	public static void bfs(int starty, int startx) {
		Queue<int[]> queue = new ArrayDeque<>(); // 저장용
		visited[starty][startx] = true; // 방문처리
		queue.offer(new int[] { starty, startx }); // 현재 노드 큐에 삽입

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int k = 0; k < 4; k++) { // 4방향 모두 방문처리 및 큐에 추가
				int dy = cur[0] + dir[k][0];
				int dx = cur[1] + dir[k][1];

				if (dy >= 0 && dy < N && dx >= 0 && dx < M && !visited[dy][dx]) {
					visited[dy][dx] = true;
					if (grid[dy][dx] == 0) {
						queue.offer(new int[] { dy, dx });
					} else {
						cheese++;
						grid[dy][dx] = 0;
					}

				}
			}
		}
	}
}
