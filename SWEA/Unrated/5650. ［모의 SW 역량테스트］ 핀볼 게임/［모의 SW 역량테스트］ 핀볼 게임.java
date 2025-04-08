import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static class Ball {
		int y, x, vec;

		public Ball(int y, int x, int vec) {
			super();
			this.y = y;
			this.x = x;
			this.vec = vec;
		}

	}

	static int n, cnt, score;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Map<Integer, List<int[]>> wormholes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine().trim());
			wormholes = new HashMap<>();

			map = new int[n][n];
			score = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6 && map[i][j] <= 10) {
						wormholes.putIfAbsent(map[i][j], new ArrayList<>());
						wormholes.get(map[i][j]).add(new int[] { i, j });
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d <= 3; d++) {
							cnt = 0;
							pinball(new Ball(i, j, d));
							score = Math.max(score, cnt);
						}
					}
				}
			}

			sb.append("#" + t + " " + score + "\n");
		}

		System.out.println(sb);
	}

	static void pinball(Ball b) {
		int y = b.y;
		int x = b.x;

		while (true) {
			int vec = b.vec;
			int dy = b.y + dir[b.vec][0];
			int dx = b.x + dir[b.vec][1];

			if (dy < 0 || dx < 0 || dy >= n || dx >= n) {
				cnt *= 2;
				cnt += 1;
				return;
			}

			int val = map[dy][dx];

			if (val == -1)
				return;

			if (val >= 6) {
				if (dy == wormholes.get(val).get(0)[0] && dx == wormholes.get(val).get(0)[1]) {
					b.y = wormholes.get(val).get(1)[0];
					b.x = wormholes.get(val).get(1)[1];
				} else {
					b.y = wormholes.get(val).get(0)[0];
					b.x = wormholes.get(val).get(0)[1];
				}
				continue;
			}

			if (vec == 0) {
				if (map[dy][dx] == 1 || map[dy][dx] == 4 || map[dy][dx] == 5) {
					cnt *= 2;
					cnt += 1;
					return;
				} else {
					if (map[dy][dx] == 2) {
						cnt += 1;
						b.vec = 3;
					} else if (map[dy][dx] == 3) {
						cnt += 1;
						b.vec = 2;
					}
				}
			} else if (vec == 1) {

				if (map[dy][dx] == 2 || map[dy][dx] == 3 || map[dy][dx] == 5) {
					cnt *= 2;
					cnt += 1;
					return;
				} else {
					if (map[dy][dx] == 1) {
						cnt += 1;
						b.vec = 3;
					} else if (map[dy][dx] == 4) {
						cnt += 1;
						b.vec = 2;
					}
				}
			} else if (vec == 2) {

				if (map[dy][dx] == 4 || map[dy][dx] == 3 || map[dy][dx] == 5) {
					cnt *= 2;
					cnt += 1;
					return;
				} else {
					if (map[dy][dx] == 1) {
						cnt += 1;
						b.vec = 0;
					} else if (map[dy][dx] == 2) {
						cnt += 1;
						b.vec = 1;
					}
				}
			} else if (vec == 3) {
				if (map[dy][dx] == 1 || map[dy][dx] == 2 || map[dy][dx] == 5) {
					cnt *= 2;
					cnt += 1;
					return;
				} else {
					if (map[dy][dx] == 3) {
						cnt += 1;
						b.vec = 1;
					} else if (map[dy][dx] == 4) {
						cnt += 1;
						b.vec = 0;
					}
				}
			}
			b.y = dy;
			b.x = dx;
			if (b.y == y && b.x == x)
				return;
		}
	}
}
