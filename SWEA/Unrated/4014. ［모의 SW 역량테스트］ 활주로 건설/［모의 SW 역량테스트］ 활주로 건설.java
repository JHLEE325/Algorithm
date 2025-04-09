import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			int res = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 가로 검사
			for (int i = 0; i < n; i++) {
				boolean[] used = new boolean[n];
				boolean ok = true;
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] == map[i][j + 1])
						continue;

					if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
						ok = false;
						break;
					}

					// 내리막 경사로
					if (map[i][j] > map[i][j + 1]) {
						for (int k = 1; k <= x; k++) {
							int nj = j + k;
							if (nj >= n || map[i][nj] != map[i][j + 1] || used[nj]) {
								ok = false;
								break;
							}
						}
						if (!ok)
							break;
						for (int k = 1; k <= x; k++) {
							used[j + k] = true;
						}
					}

					// 오르막 경사로
					else {
						for (int k = 0; k < x; k++) {
							int nj = j - k;
							if (nj < 0 || map[i][nj] != map[i][j] || used[nj]) {
								ok = false;
								break;
							}
						}
						if (!ok)
							break;
						for (int k = 0; k < x; k++) {
							used[j - k] = true;
						}
					}
				}
				if (ok)
					res++;
			}

			// 세로 검사
			for (int i = 0; i < n; i++) {
				boolean[] used = new boolean[n];
				boolean ok = true;
				for (int j = 0; j < n - 1; j++) {
					if (map[j][i] == map[j + 1][i])
						continue;

					if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
						ok = false;
						break;
					}

					// 내리막 경사로
					if (map[j][i] > map[j + 1][i]) {
						for (int k = 1; k <= x; k++) {
							int nj = j + k;
							if (nj >= n || map[nj][i] != map[j + 1][i] || used[nj]) {
								ok = false;
								break;
							}
						}
						if (!ok)
							break;
						for (int k = 1; k <= x; k++) {
							used[j + k] = true;
						}
					}

					// 오르막 경사로
					else {
						for (int k = 0; k < x; k++) {
							int nj = j - k;
							if (nj < 0 || map[nj][i] != map[j][i] || used[nj]) {
								ok = false;
								break;
							}
						}
						if (!ok)
							break;
						for (int k = 0; k < x; k++) {
							used[j - k] = true;
						}
					}
				}
				if (ok)
					res++;
			}

			sb.append("#" + t + " " + res + "\n");
		}

		System.out.println(sb);
	}
}
