import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int count=0;
			boolean[] chk = new boolean[n+1];

			parent = MakeSet(n);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());

				union(n1, n2);

			}
			
			for(int i=1;i<=n;i++) {
				chk[find(i)]=true;
			}
			for(int i=1;i<=n;i++) {
				if(chk[i])
					count++;
			}

			sb.append("#" + t + " " + count + "\n");
		}
		System.out.println(sb);
	}

	// Union
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	// Find
	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	// makeSet
	private static int[] MakeSet(int size) {
		int[] arr = new int[size + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}

}
