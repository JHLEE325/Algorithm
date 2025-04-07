import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static class Rock implements Comparable<Rock> {
		int idx, width, height, weight;

		public Rock(int idx, int width, int height, int weight) {
			super();
			this.idx = idx;
			this.width = width;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Rock o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Rock [idx=" + idx + ", width=" + width + ", height=" + height + ", weight=" + weight + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		List<Rock> tower = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tower.add(new Rock(i, w, h, weight));
		}

		int[] dp = new int[n];
		int[] stack = new int[n];
		Arrays.fill(stack, -1);
		Collections.sort(tower);

		for (int i = 0; i < n; i++) {
			dp[i] = tower.get(i).height;
		}

		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (tower.get(i).width > tower.get(j).width && tower.get(i).weight > tower.get(j).weight) {
					if (dp[i] < dp[j] + tower.get(i).height) {
						dp[i] = Math.max(dp[i], dp[j] + tower.get(i).height);
						stack[i] = j;
					}
				}
			}
		}
		int max, midx;
		max = midx = -1;
		for(int i=0;i<n;i++) {
			if(max<dp[i]) {
				max = dp[i];
				midx = i;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		while(midx != -1) {
		    list.add(tower.get(midx).idx);
		    midx = stack[midx];
		}
		Collections.reverse(list);
		sb.append(list.size()+"\n");
		for(int a:list) {
			sb.append(a+"\n");
		}
		
		System.out.println(sb);
	}
}
