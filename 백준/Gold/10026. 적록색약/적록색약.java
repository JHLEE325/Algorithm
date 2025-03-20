import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[][] arr2;
	static int n, m, s;
	static boolean[][] visited;
	static int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		arr2 = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				char c = str.charAt(j);
				if (c == 'R') {
					arr[i][j] = 1;
					arr2[i][j]=1;
				} else if (c == 'G') {
					arr[i][j] = 2;
					arr2[i][j]=1;
				} else if (c == 'B') {
					arr[i][j] = 3;
					arr2[i][j]=3;
				}
			}
		}

		int count=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]&&arr[i][j]==1) {
					count++;
					bfs(new int[] {i,j},1);
				}
				else if(!visited[i][j]&&arr[i][j]==2) {
					count++;
					bfs(new int[] {i,j},2);
				}
				else if(!visited[i][j]&&arr[i][j]==3) {
					count++;
					bfs(new int[] {i,j},3);
				}
			}
		}
		
		int count2=0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]&&arr2[i][j]==1) {
					count2++;
					bfs2(new int[] {i,j},1);
				}
				else if(!visited[i][j]&&arr2[i][j]==3) {
					count2++;
					bfs2(new int[] {i,j},3);
				}
			}
		}
		
		System.out.println(count+" "+count2);

	}

	static void bfs(int[] start, int col) {
		Queue<int[]> list = new ArrayDeque<>();
		list.add(start);
		visited[start[0]][start[1]] = true;

		while (list.size() != 0) {
			int[] idx = list.poll();
			for (int i = 0; i < 4; i++) {
				int dy = idx[0] + dir[i][0];
				int dx = idx[1] + dir[i][1];
				if (dx >= 0 && dx < n && dy >= 0 && dy < n && !visited[dy][dx] && arr[dy][dx] == col) {
					visited[dy][dx] = true;
					list.add(new int[] { dy, dx });
				}
			}

		}
	}
	static void bfs2(int[] start, int col) {
		Queue<int[]> list = new ArrayDeque<>();
		list.add(start);
		visited[start[0]][start[1]] = true;

		while (list.size() != 0) {
			int[] idx = list.poll();
			for (int i = 0; i < 4; i++) {
				int dy = idx[0] + dir[i][0];
				int dx = idx[1] + dir[i][1];
				if (dx >= 0 && dx < n && dy >= 0 && dy < n && !visited[dy][dx] && arr2[dy][dx] == col) {
					visited[dy][dx] = true;
					list.add(new int[] { dy, dx });
				}
			}

		}
	}
}
