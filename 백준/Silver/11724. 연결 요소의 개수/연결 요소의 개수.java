import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] adjMatrix;
	static int N,M,ans;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			adjMatrix[x][y]=1;
			adjMatrix[y][x]=1;
		}
		
		ans=0;
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				bfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();

		visited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for(int i=0;i<N;i++) {
				if(adjMatrix[current][i] != 1 || visited[i])continue;
				
				visited[i]=true;
				queue.offer(i);
			}
		}
	}
	
}
