import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] line;
	static boolean[] visited;
	static int N, K, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];
		line = new int[100001];
		bfs(N);
		
		System.out.println(line[K]);
	}

	public static void bfs(int start) {
		Queue<Integer> list = new ArrayDeque<>();
		visited[start] = true;
		list.offer(start);

		while (!list.isEmpty()) {
			int n = list.size();
			for(int k=0;k<n;k++) {
				int cur = list.poll();
				line[cur]=count;
				if (cur == K)
					return;
				for (int i = 0; i < 3; i++) {
					int dx = cur;
					if (i == 0) {
						dx += 1;
					} else if (i == 1) {
						dx -= 1;
					} else {
						dx *= 2;
					}
					if(dx>=0&&dx<100001&&!visited[dx]) {
						list.offer(dx);
						visited[dx]=true;
					}
				}
			}
			count++;
		}
	}

}
