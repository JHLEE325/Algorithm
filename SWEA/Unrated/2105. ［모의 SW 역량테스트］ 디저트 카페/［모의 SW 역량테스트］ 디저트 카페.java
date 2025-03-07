import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dessert;
	static int N, max, y, x;
	static int[][] dir = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
	static Set<Integer> hash;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			dessert = new int[N][N];
			max = -1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					dessert[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					for (int i = 1; i <= N - 1; i++) {
						for (int j = 1; j <= N - 1; j++) {
							boolean isvalid = true;
							int cnt = 0;
							hash = new HashSet<>();
							for (int r = 0; r <= i && isvalid; r++) {
								y = a + dir[0][0] * r;
								x = b + dir[0][1] * r;
								if (y >= 0 && y < N && x >= 0 && x < N && !hash.contains(dessert[y][x])) {
									hash.add(dessert[y][x]);
									cnt++;
								} else {
									isvalid = false;
									break;
								}
							}
							for (int r = 1; r <= j && isvalid; r++) {
								y = y + dir[1][0];
								x = x + dir[1][1];
								if (y >= 0 && y < N && x >= 0 && x < N && !hash.contains(dessert[y][x])) {
									hash.add(dessert[y][x]);
									cnt++;
								} else {
									isvalid = false;
									break;
								}
							}
							for (int r = 1; r <= i && isvalid; r++) {
								y = y + dir[2][0];
								x = x + dir[2][1];
								if (y >= 0 && y < N && x >= 0 && x < N && !hash.contains(dessert[y][x])) {
									hash.add(dessert[y][x]);
									cnt++;
								} else {
									isvalid = false;
									break;
								}
							}
							for (int r = 1; r <= j - 1 && isvalid; r++) {
								y = y + dir[3][0];
								x = x + dir[3][1];
								if (y >= 0 && y < N && x >= 0 && x < N && !hash.contains(dessert[y][x])) {
									hash.add(dessert[y][x]);
									cnt++;
								} else {
									isvalid = false;
									break;
								}
							}
							if (isvalid) {
								max = Math.max(max, cnt);
							}
						}
					}

				}
			}

			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
