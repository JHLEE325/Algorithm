import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static long temp, a, b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		bfs(a);

	}

	public static void bfs(long idx) {
		Queue<Long> queue = new ArrayDeque<>();
		queue.add(idx);
		while (!queue.isEmpty()) {
			
			int s = queue.size();
			for (int i = 0; i < s; i++) {
				long cur = queue.poll();
				if (cur == b) {
					System.out.println(temp+1);
					return;
				}
				long k;
				for (int j = 0; j < 2; j++) {
					if (j == 0) {
						k = cur * 2;
					} else {
						k = (cur * 10) + 1;
					}

					if (k <= b) {
						queue.add(k);
					}
				}
			}
			temp++;
		}
		System.out.println("-1");
	}

}
