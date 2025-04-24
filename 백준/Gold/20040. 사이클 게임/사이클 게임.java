import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n];
		for (int i = 0; i < n; i++) {
		    parent[i] = i;
		}
		boolean chk = false;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) {
				System.out.println(i);
				chk = true;
				break;
			}
		}

		if (!chk)
			System.out.println("0");
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb)
			return false;
		parent[pa] = pb;
		return true;
	}

}
