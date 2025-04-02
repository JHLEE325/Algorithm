import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static boolean[][] visited;
	static int n, m, r, c, l, res, count;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			visited = new boolean[n][m];
			res = 0;
			count = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(new int[] { r, c });

			sb.append("#" + t + " " + res + "\n");
		}
		System.out.println(sb);
	}

	static void bfs(int[] start) {

		visited[start[0]][start[1]] = true;
		Queue<int[]> list = new ArrayDeque<>();
		list.add(start);
		count++;
		res++;

		while (!list.isEmpty()) {
			if (count == l)
				break;
			int s = list.size();
			for (int seq = 0; seq < s; seq++) {
				int[] cur = list.poll();
				int pipe = map[cur[0]][cur[1]];
				int dy, dx;

				if (pipe == 1) {
					dy = cur[0] + dir[0][0];
					dx = cur[1] + dir[0][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 5 || map[dy][dx] == 6) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[1][0];
					dx = cur[1] + dir[1][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 4 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[2][0];
					dx = cur[1] + dir[2][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 4 || map[dy][dx] == 5) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[3][0];
					dx = cur[1] + dir[3][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 6 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}
				} else if (pipe == 2) {
					dy = cur[0] + dir[0][0];
					dx = cur[1] + dir[0][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 5 || map[dy][dx] == 6) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[1][0];
					dx = cur[1] + dir[1][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 4 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}
				} else if (pipe == 3) {
					dy = cur[0] + dir[2][0];
					dx = cur[1] + dir[2][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 4 || map[dy][dx] == 5) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[3][0];
					dx = cur[1] + dir[3][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 6 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}
				} else if (pipe == 4) {
					dy = cur[0] + dir[0][0];
					dx = cur[1] + dir[0][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 5 || map[dy][dx] == 6) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[3][0];
					dx = cur[1] + dir[3][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 6 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}
				} else if (pipe == 5) {
					dy = cur[0] + dir[1][0];
					dx = cur[1] + dir[1][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 4 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[3][0];
					dx = cur[1] + dir[3][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 6 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}
				} else if (pipe == 6) {
					dy = cur[0] + dir[1][0];
					dx = cur[1] + dir[1][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 4 || map[dy][dx] == 7) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[2][0];
					dx = cur[1] + dir[2][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 4 || map[dy][dx] == 5) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}
				} else {
					dy = cur[0] + dir[0][0];
					dx = cur[1] + dir[0][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 5 || map[dy][dx] == 6) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}

					dy = cur[0] + dir[2][0];
					dx = cur[1] + dir[2][1];

					if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
						if (map[dy][dx] == 1 || map[dy][dx] == 3 || map[dy][dx] == 4 || map[dy][dx] == 5) {
							list.add(new int[] { dy, dx });
							visited[dy][dx] = true;
							res++;
						}
					}
				}
			}
			count++;
		}

	}
}
