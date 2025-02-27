import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] room;
	static int maxmove = 0, maxroom = 0, N;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			maxmove=0;
			maxroom=0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					checkroom(i,j,1);
				}
			}
			
			sb.append("#"+t+" "+maxroom+" "+maxmove+"\n");
		}
		System.out.println(sb);
	}

	public static int checkroom(int i, int j, int cnt) {
		for (int n = 0; n < 4; n++) {
			int x = j + delta[n][1];
			int y = i + delta[n][0];

			if (x < 0 || y < 0 || x >= N || y >= N)
				continue;
			else if (room[y][x] != room[i][j] + 1)
				continue;

			cnt = checkroom(y, x, cnt + 1);

			if (maxmove < cnt) {
				maxmove = cnt;
				maxroom = room[i][j];
			} else if (maxmove == cnt && maxroom > room[i][j]) {
				maxroom = room[i][j];
			}

			break;
		}

		return cnt;
	}

}