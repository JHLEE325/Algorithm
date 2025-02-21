import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] chk;
	static int N, M, count;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			chk = new int[M][2];
			isSelected = new boolean[N];
			count = 0;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				chk[i][0] = Integer.parseInt(st.nextToken())-1;
				chk[i][1] = Integer.parseInt(st.nextToken())-1;
			}
			
			subset(0);

			sb.append("#"+t+" "+count+"\n");
		}
		
		System.out.println(sb);
	}

	public static void subset(int cnt) {

		if (cnt == N) {
			for (int i = 0; i < M; i++) {
				if (isSelected[chk[i][0]] && isSelected[chk[i][1]]) {
					return;
				}
			}
			count++;
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}