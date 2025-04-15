import java.io.*;
import java.util.*;

public class Solution {

	static class Cell implements Comparable<Cell> {
		int y, x, life, time; // 좌표, 생명력, 시작 시간
		boolean active;

		public Cell(int y, int x, int life, int time, boolean active) {
			this.y = y;
			this.x = x;
			this.life = life;
			this.time = time;
			this.active = active;
		}

		// 생명력이 높은 순으로 우선
		@Override
		public int compareTo(Cell o) {
			return o.life - this.life;
		}
	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int n, m, k;
	static int OFFSET = 200; // 좌표를 양수로 offset 처리
	static boolean[][] visited = new boolean[700][700];
	static List<Cell> cellList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			cellList = new ArrayList<>();
			visited = new boolean[500][500];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int val = Integer.parseInt(st.nextToken());
					if (val > 0) {
						int ny = i + OFFSET;
						int nx = j + OFFSET;
						cellList.add(new Cell(ny, nx, val, 0, false)); // 비활성 세포로 시작
						visited[ny][nx] = true;
					}
				}
			}

			simulate();

			// 살아있는 세포 측정
			int alive = 0;
			for (Cell c : cellList) {
				if ((c.active && c.time + c.life > k) || (!c.active && c.time + c.life > k)) {
					alive++;
				}
			}
			sb.append("#").append(t).append(" ").append(alive).append("\n");
		}
		System.out.println(sb);
	}

	static void simulate() {
		for (int time = 1; time <= k; time++) {
			PriorityQueue<Cell> pq = new PriorityQueue<>();

			for (Cell c : cellList) {
				if (!c.active && c.time + c.life == time) { // 세포 활성화 시키기
					c.active = true;
					c.time = time;
				} else if (c.active && c.time + 1 == time) { // 활성화 이후 1초 지났으면 번식
					pq.offer(c);
				}
			}

			while (!pq.isEmpty()) { // 생명력 순으로 pq 사용하여번식시킴
				Cell cur = pq.poll();

				for (int d = 0; d < 4; d++) {
					int dy = cur.y + dir[d][0];
					int dx = cur.x + dir[d][1];

					if (!visited[dy][dx]) { // 방문처리 통해서 우선순위 높은 세포가 먹었으면 못먹게함
						visited[dy][dx] = true;
						cellList.add(new Cell(dy, dx, cur.life, time, false));
					}
				}
			}
		}
	}

}
