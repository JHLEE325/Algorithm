import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class gunzip {
		int y, x, pow, dir;

		public gunzip(int y, int x, int pow, int dir) {
			this.y = y;
			this.x = x;
			this.pow = pow;
			this.dir = dir;
		}

	}

	static int N, M, K;
	static int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			List<gunzip> list = new ArrayList<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int pow = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				list.add(new gunzip(y, x, pow, dir));
			}

			Collections.sort(list, new Comparator<gunzip>() {
				@Override
				public int compare(gunzip g1, gunzip g2) {
					return Integer.compare(g2.pow, g1.pow); // 내림차순
				}
			});

			for (int time = 1; time <= M; time++) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).pow == 0)
						continue;
					list.get(i).y = list.get(i).y + dir[list.get(i).dir][0];
					list.get(i).x = list.get(i).x + dir[list.get(i).dir][1];

					if (list.get(i).y == 0) {
						list.get(i).pow /= 2;
						list.get(i).dir = 2;
					} else if (list.get(i).y == N - 1) {
						list.get(i).pow /= 2;
						list.get(i).dir = 1;
					} else if (list.get(i).x == 0) {
						list.get(i).pow /= 2;
						list.get(i).dir = 4;
					} else if (list.get(i).x == N - 1) {
						list.get(i).pow /= 2;
						list.get(i).dir = 3;
					}
				}

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).pow == 0)
						continue;
					for (int j = i + 1; j < list.size(); j++) {
						if (list.get(j).pow == 0)
							continue;
						if (list.get(i).y == list.get(j).y && list.get(i).x == list.get(j).x) {
							list.get(i).pow += list.get(j).pow;
							list.get(j).pow = 0;
						}
					}
				}

				Collections.sort(list, new Comparator<gunzip>() {
					@Override
					public int compare(gunzip g1, gunzip g2) {
						return Integer.compare(g2.pow, g1.pow); // 내림차순
					}
				});
			}

			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i).pow;
			}

			sb.append("#"+t+" "+sum+"\n");
		}
		
		System.out.println(sb);
	}

}
