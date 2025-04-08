import java.io.*;
import java.util.*;

public class Main {

	static int n, m, cnt;
	static int[][] map;
	static int[][] val;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static Map<Integer, Integer> hash = new HashMap<>();
	static int id = 1;
	static int[] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		val = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					hash.put(id, cnt);
					id++;
				}
			}
		}

		chk = new int[hash.size() + 1];
		int marker = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					int tmp = 1;
					for (int d = 0; d < 4; d++) {
						int dy = i + dir[d][0];
						int dx = j + dir[d][1];
						if (dy >= 0 && dy < n && dx >= 0 && dx < m && map[dy][dx] == 0 && chk[val[dy][dx]] != marker) {
							if (val[dy][dx] != 0) {
								tmp += hash.get(val[dy][dx]);
								chk[val[dy][dx]] = marker;
							}
						}
					}
					map[i][j] = tmp % 10;
					marker++;
				}
			}
		}

		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b);
			}
			System.out.println();
		}

	}

	static void dfs(int y, int x) {
		visited[y][x] = true;
		val[y][x] = id;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int dy = y + dir[i][0];
			int dx = x + dir[i][1];

			if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx] && map[dy][dx] == 0) {
				dfs(dy, dx);
			}
		}
	}
}