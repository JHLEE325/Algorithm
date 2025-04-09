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

			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (i == j)
					    map[i][j] = 0;
					else if (num == 0)
						map[i][j] = Integer.MAX_VALUE / 3;
					else
						map[i][j] = 1;
				}
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}

			int res = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				int tmp = 0;
				for (int j = 0; j < n; j++) {
					tmp += map[i][j];
				}
				res = Math.min(res, tmp);
			}

			sb.append("#" + t + " " + res + "\n");
		}

		System.out.println(sb);
	}

}
