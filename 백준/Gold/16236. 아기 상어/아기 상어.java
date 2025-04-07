import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static class Shark {
		int y, x, size, eat;

		public Shark(int y, int x, int size, int eat) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.eat = eat;
		}
	}

	static int[][] map;
	static int n, res;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static Shark s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					s = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			int move = bfs();
			if (move == -1) break;

			res += move;

			if (s.size == s.eat) {
				s.size++;
				s.eat = 0;
			}
		}

		System.out.println(res);
	}

	public static int bfs() {
		Queue<int[]> list = new ArrayDeque<>();
		visited = new boolean[n][n];
		list.add(new int[] { s.y, s.x });
		visited[s.y][s.x] = true;

		List<int[]> targets = new ArrayList<>();
		int step = 0;

		while (!list.isEmpty()) {
			int size = list.size();
			step++;

			for (int i = 0; i < size; i++) {
				int[] cur = list.poll();

				for (int d = 0; d < 4; d++) {
					int dy = cur[0] + dir[d][0];
					int dx = cur[1] + dir[d][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < n && !visited[dy][dx]) {
						if (map[dy][dx] <= s.size) {
							visited[dy][dx] = true;

							if (map[dy][dx] != 0 && map[dy][dx] < s.size) {
								targets.add(new int[] { dy, dx });
							}

							list.add(new int[] { dy, dx });
						}
					}
				}
			}

			if (!targets.isEmpty()) {
				targets.sort((a, b) -> {
					if (a[0] != b[0]) return a[0] - b[0]; // 위쪽
					return a[1] - b[1]; // 왼쪽
				});

				int[] target = targets.get(0);
				s.y = target[0];
				s.x = target[1];
				s.eat++;
				map[s.y][s.x] = 0;
				return step;
			}
		}

		return -1;
	}
}
