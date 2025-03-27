import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}
		
	}
	
	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	static int[][] node;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			V = Integer.parseInt(br.readLine());
			node = new int[V][V];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<V;i++) {
				node[i][0]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<V;i++) {
				node[i][1]=Integer.parseInt(st.nextToken());
			}
			
			double tax = Double.parseDouble(br.readLine());
			
			edgeList = new Edge[V*(V-1)];
			int cnt = 0;
			parents = new int[V];
			
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					if(i==j)continue;
					double l = Math.sqrt(Math.pow(node[i][0]-node[j][0], 2)+Math.pow(node[i][1]-node[j][1],2));
					double w = tax * l * l;
					edgeList[cnt] = new Edge(i,j,w);
					cnt++;
				}
				parents[i]=i;
			}
			
			Arrays.sort(edgeList);
			double result = 0, count = 0;

			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) {
					result += edge.weight;
					if (++count == V - 1) {
						break;
					}
				}
			}
			
			sb.append("#"+t+" "+Math.round(result)+"\n");
		}
		
		System.out.println(sb);
	}
	
	static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

}
