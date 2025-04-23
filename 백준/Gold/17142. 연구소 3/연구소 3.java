import java.io.*;
import java.util.*;

public class Main {

	static int n, v, m, res;
	static List<int[]> virus = new ArrayList<>();
	static int[][] map;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] num;
	static final int INF = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		res = INF;
		map = new int[n][n];
		num = new int[m];
		int cntzero = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 2) {
					virus.add(new int[] { i, j });
					v++;
				}
				if (a == 0)
					cntzero++;
				map[i][j] = a;
			}
		}

		if (cntzero == 0)
			System.out.println("0");
		else {

			combination(0, 0);

			if (res == INF)
				System.out.println("-1");
			else
				System.out.println(res);
		}
	}

	static void bfs(boolean[][] visited, Queue<int[]> q) {
	    int[][] time = new int[n][n];
	    int max = 0;

	    while (!q.isEmpty()) {
	        int[] cur = q.poll();
	        for (int d = 0; d < 4; d++) {
	            int dy = cur[0] + dir[d][0];
	            int dx = cur[1] + dir[d][1];

	            if (dy >= 0 && dy < n && dx >= 0 && dx < n && map[dy][dx] != 1 && !visited[dy][dx]) {
	                visited[dy][dx] = true;
	                time[dy][dx] = time[cur[0]][cur[1]] + 1;
	                q.add(new int[] { dy, dx });
	            }
	        }
	    }

	    boolean success = true;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            if (map[i][j] == 0) {
	                if (!visited[i][j]) {
	                    success = false;
	                    break;
	                } else {
	                    max = Math.max(max, time[i][j]);
	                }
	            }
	        }
	    }

	    if (success) {
	        res = Math.min(res, max);
	    }
	}


	static void combination(int cnt, int start) {
		if (cnt == m) {
			boolean[][] visited = new boolean[n][n];
			Queue<int[]> q = new ArrayDeque<>();
			for (int i = 0; i < m; i++) {
				int[] cur = virus.get(num[i]);
				visited[cur[0]][cur[1]] = true;
				q.add(cur);
			}
			bfs(visited, q);
			return;
		}

		for (int i = start; i < virus.size(); i++) {
			num[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

}
