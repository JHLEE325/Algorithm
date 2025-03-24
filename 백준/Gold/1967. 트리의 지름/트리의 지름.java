import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class node {
		int idx;
		int w;

		public node(int idx, int weight) {
			this.idx = idx;
			w = weight;
		}

	}

	static ArrayList<node>[] list;
	static int mweight, res, fidx;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[p].add(new node(c, w));
			list[c].add(new node(p, w));
		}
		
		search(1,0);
		mweight=0;
		search(fidx,0);
		res = mweight;
		System.out.println(res);
	}

	public static void search(int idx, int weight) {

		visited[idx] = true;

		if (mweight < weight) {
			fidx = idx;
			mweight = weight;
		}

		for (int i = 0; i < list[idx].size(); i++) {
			if (!visited[list[idx].get(i).idx])
				search(list[idx].get(i).idx, weight + list[idx].get(i).w);
		}

		visited[idx] = false;
	}

}
