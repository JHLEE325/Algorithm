import java.io.*;
import java.util.*;

public class Solution {

	static class Atom {
		int y, x, dir, pow;
		boolean isalive = true;

		public Atom(int y, int x, int dir, int pow) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.pow = pow;
		}
	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하, 좌, 우
	static int n, res;
	static List<Atom> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			res = 0;
			list = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) * 2 + 2000;
				int y = Integer.parseInt(st.nextToken()) * 2 + 2000;
				int dir = Integer.parseInt(st.nextToken());
				int pow = Integer.parseInt(st.nextToken());

				list.add(new Atom(y, x, dir, pow));
			}

			move();

			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		System.out.println(sb);
	}

	static void move() {
		Map<String, List<Integer>> map = new HashMap<>();
		for (int t = 0; t < 4000; t++) {
			map.clear();

			boolean anyAlive = false;

			for (int i = 0; i < n; i++) {
				Atom atom = list.get(i);
				if (!atom.isalive)
					continue;
				int dy = atom.y - dir[atom.dir][0];
				int dx = atom.x + dir[atom.dir][1];

				if (dy < 0 || dy > 4001 || dx < 0 || dx > 4001) {
					atom.isalive = false;
					continue;
				}

				atom.y = dy;
				atom.x = dx;

				String key = dy + "," + dx;
				map.putIfAbsent(key, new ArrayList<>());
				map.get(key).add(i);
				anyAlive = true;
			}

			if (!anyAlive)
				break;

			for (List<Integer> crashlist : map.values()) {
				if (crashlist.size() >= 2) {
					for (int idx : crashlist) {
						res += list.get(idx).pow;
						list.get(idx).isalive = false;
					}
				}
			}
		}
	}
}
