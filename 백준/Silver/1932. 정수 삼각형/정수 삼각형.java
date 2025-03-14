import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr = new int[501][501];
	static int[][] dp = new int[501][501];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int max = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][j] = tmp;
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				if(dp[i][j]>max) {
					max = dp[i][j];
				}
			}
		}
		
		System.out.println(max);

	}
}
