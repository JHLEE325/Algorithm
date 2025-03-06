import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, ans, max;
	static int[][] map;
	static boolean[][] chk;
	static boolean temp;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		// --------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}
			max = 0;

			chk = new boolean[N][M];
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp = false;
					safespace(i, j);
					if (temp) {
						ans++;
					}
				}
			}
			if (max < ans) {
				max = ans;
			}

			System.out.println(max);
		}
	}

	public static void safespace(int y, int x) {
		if (chk[y][x] || map[y][x] != 1) {
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				int dy = y + dir[i][0];
				int dx = x + dir[i][1];

				if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
					continue;
				} else {
					chk[y][x] = true;
					temp = true;
					safespace(dy, dx);
				}
			}
		}
		return;
	}

}
