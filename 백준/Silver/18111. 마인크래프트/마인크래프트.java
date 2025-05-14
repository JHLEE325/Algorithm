import java.io.*;
import java.util.*;

public class Main {

	static int n, m, b;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		int max = 256;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
			}
		}

		int restime = Integer.MAX_VALUE;
		int resh = 0;

		for (int h = 0; h <= 256; h++) {
			int remove = 0;
			int place = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] > h) {
						remove += map[i][j] - h;
					} else {
						place += h - map[i][j];
					}
				}
			}

			if (remove + b >= place) {
				int time = remove * 2 + place;
				if (time <= restime) {
					restime = time;
					resh = h;
				}
			}
		}
		System.out.println(restime + " " + resh);
	}
}
