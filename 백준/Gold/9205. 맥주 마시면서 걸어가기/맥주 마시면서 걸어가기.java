import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] pos;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			n = Integer.parseInt(br.readLine()) + 2;
			pos = new int[n][2];
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}

			int INF = 9999999;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						map[i][j] = 0;
					else {
						if (Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]) <= 1000) {
							map[i][j] = 1;
						} else {
							map[i][j] = INF;
						}
					}
				}
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}

			if (map[0][n - 1] == INF) {
				sb.append("sad\n");
			} else {
				sb.append("happy\n");
			}
		}

		System.out.println(sb);
	}

}
