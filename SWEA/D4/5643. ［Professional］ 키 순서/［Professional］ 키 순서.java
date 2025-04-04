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

			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			int cnt = 0;

			int[][] height = new int[n][n];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				height[from - 1][to - 1] = 1;
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (height[i][k] == 1 && height[k][j] == 1) {
							height[i][j] = 1;
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
			    int tall = 0;
			    int small = 0;

			    for (int j = 0; j < n; j++) {
			        if (height[i][j] == 1) tall++;
			        if (height[j][i] == 1) small++;
			    }

			    if (tall + small == n - 1) cnt++;
			}


			sb.append("#" + t + " " + cnt + "\n");
		}

		System.out.println(sb);
	}
}
