import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dir = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] a = new int[M + 1];
			int[] b = new int[M + 1];
			int[] pa = { 1, 1 };
			int[] pb = { 10, 10 };
			int[][] list = new int[A][4];
			result = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				list[i][0] = Integer.parseInt(st.nextToken());
				list[i][1] = Integer.parseInt(st.nextToken());
				list[i][2] = Integer.parseInt(st.nextToken());
				list[i][3] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i <= M; i++) {
				List<Integer> acharger = new ArrayList<>();
				List<Integer> bcharger = new ArrayList<>();
				pa[0] += dir[a[i]][0];
				pa[1] += dir[a[i]][1];
				pb[0] += dir[b[i]][0];
				pb[1] += dir[b[i]][1];

				for (int j = 0; j < A; j++) {
					if ((Math.abs(pa[0] - list[j][0]) + Math.abs(pa[1] - list[j][1])) <= list[j][2]) {
						acharger.add(j);
					}
					if ((Math.abs(pb[0] - list[j][0]) + Math.abs(pb[1] - list[j][1])) <= list[j][2]) {
						bcharger.add(j);
					}
				}

				int maxpower = 0;
				
				if(acharger.size()!=0&&bcharger.size()!=0) {
					for (int ac : acharger) {
						for (int bc : bcharger) {
							if (ac == bc) {
								maxpower = Math.max(maxpower, list[bc][3]);
							} else {
								maxpower = Math.max(maxpower, list[bc][3] + list[ac][3]);
							}
						}
					}
				}
				else if(acharger.size()!=0&&bcharger.size()==0) {
					for(int ac:acharger) {
						maxpower = Math.max(maxpower, list[ac][3]);
					}
				}
				else if(acharger.size()==0&&bcharger.size()!=0) {
					for(int bc:bcharger) {
						maxpower = Math.max(maxpower, list[bc][3]);
					}
				}
				
				result+=maxpower;
			}

			sb.append("#"+t+" "+result+"\n");
		}
		
		System.out.println(sb);
	}
}
