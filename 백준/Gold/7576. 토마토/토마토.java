import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] tomato;
	static boolean[][] visited;
	static int M, N, count;
	static Queue<int[]> list = new ArrayDeque<>();
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomato = new int[N][M];
		visited = new boolean[N][M];
		count = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				tomato[i][j] = num;
				if (num == 1) {
					visited[i][j] = true;
					list.offer(new int[] {i,j});
				}
			}
		}
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tomato[i][j]==0) {
					count=-1;
				}
			}
		}
		System.out.println(count);

	}

	public static void bfs() {

		while (!list.isEmpty()) {
			int n = list.size();
			for (int k = 0; k < n; k++) {
				int[] cur = list.poll();
				
				for(int i=0;i<4;i++) {
					int dy = cur[0]+dir[i][0];
					int dx = cur[1]+dir[i][1];
					
					if(dy>=0&&dy<N&&dx>=0&&dx<M&&!visited[dy][dx]&&tomato[dy][dx]==0) {
						tomato[dy][dx]=1;
						visited[dy][dx]=true;
						list.offer(new int[] {dy,dx});
					}
				}
			}
			count++;
		}
	}

}
