import java.io.*;
import java.util.*;

public class Main {

	static int r, c;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> dochi = new ArrayDeque<>();
	static Queue<int[]> water = new ArrayDeque<>();
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == 'S') {
					dochi.add(new int[] { i, j });
					map[i][j] = 0;
					visited[i][j] = true;
				} else if (str.charAt(j) == '.') {
					map[i][j] = 0;
				} else if (str.charAt(j) == '*') {
					map[i][j] = 2;
					water.add(new int[] { i, j });
					visited[i][j] = true;
				} else if (str.charAt(j) == 'X') {
					map[i][j] = 1;
				} else {
					map[i][j] = 9;
				}
			}
		}

		bfs();
	}

	static void bfs() {
		int count = 0;
		while (!dochi.isEmpty()) {
			int wsize = water.size();
			for (int s = 0; s < wsize; s++) {
				int[] cur = water.poll();
				for (int d = 0; d < 4; d++) {
					int dy = cur[0] + dir[d][0];
					int dx = cur[1] + dir[d][1];
					if (dy >= 0 && dy < r && dx >= 0 && dx < c && !visited[dy][dx] && map[dy][dx] == 0) {
						water.add(new int[] { dy, dx });
						map[dy][dx] = 2;
					}
				}
			}
			int dsize = dochi.size();
			for (int s = 0; s < dsize; s++) {
				int[] cur = dochi.poll();
				if (map[cur[0]][cur[1]] == 9) {
					System.out.println(count);
					return;
				}
				for (int d = 0; d < 4; d++) {
					int dy = cur[0] + dir[d][0];
					int dx = cur[1] + dir[d][1];
					if (dy >= 0 && dy < r && dx >= 0 && dx < c && !visited[dy][dx]
							&& (map[dy][dx] == 0 || map[dy][dx] == 9)) {
						dochi.add(new int[] { dy, dx });
						visited[dy][dx] = true;
					}
				}
			}
			count++;
		}
		System.out.println("KAKTUS");
	}

}
