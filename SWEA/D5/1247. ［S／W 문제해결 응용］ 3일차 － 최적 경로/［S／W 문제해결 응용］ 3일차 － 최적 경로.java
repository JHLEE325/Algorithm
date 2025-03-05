import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] company, home;
	static int[][] customer;
	static int route, N;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new int[2];
			home = new int[2];
			route = Integer.MAX_VALUE;
			isSelected = new boolean[N];

			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			customer = new int[N][2];

			for (int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			
			findroute(0,company[0], company[1],0);
			
			sb.append("#"+t+" "+route+"\n");
		}
		
		System.out.println(sb);
	}

	public static void findroute(int cnt, int x, int y, int dist) {
		if (cnt == N) {
			dist += Math.abs(x-home[0]);
			dist += Math.abs(y-home[1]);
			
			if(route>dist)
				route=dist;
			
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isSelected[i])
				continue;
			isSelected[i]=true;
			findroute(cnt+1,customer[i][0],customer[i][1],dist+Math.abs(x-customer[i][0])+Math.abs(y-customer[i][1]));
			isSelected[i]=false;
		}
	}

}
