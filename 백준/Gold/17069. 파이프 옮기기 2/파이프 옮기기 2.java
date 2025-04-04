import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
	static long[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		dp = new long[n + 1][n + 1][3];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][2][0] = 1;

		for (int y = 1; y <= n; y++) {
		    for (int x = 3; x <= n; x++) {
		        if (map[y][x] == 0) {
		            dp[y][x][0] = dp[y][x - 1][0] + dp[y][x - 1][2];
		            dp[y][x][1] = dp[y - 1][x][1] + dp[y - 1][x][2];
		        }

		        if (map[y][x] == 0 && map[y - 1][x] == 0 && map[y][x - 1] == 0) {
		            dp[y][x][2] = dp[y - 1][x - 1][0] + dp[y - 1][x - 1][1] + dp[y - 1][x - 1][2];
		        }
		    }
		}


		System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);
	}
}
