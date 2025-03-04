import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, ans, max;
	static int[][] map;
	static boolean[][] chk;
	static boolean temp;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		// --------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 1;
		for(int num=1;num<=100;num++) {
			chk = new boolean[N][N];
			ans=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					temp=false;
					safespace(i,j,num);
					if(temp) {
						ans++;
					}
				}
			}
			if(max<ans) {
				max = ans;
			}
		}

		System.out.println(max);
	}

	public static void safespace(int y, int x, int num) {
		
		if(chk[y][x]||map[y][x]<=num) {
			return;
		}
		else {
			for(int i=0;i<4;i++) {
				int dy = y+dir[i][0];
				int dx = x+dir[i][1];
				
				if(dy<0||dy>=N||dx<0||dx>=N) {
					continue;
				}
				else {
					chk[y][x]=true;
					temp = true;
					safespace(dy,dx,num);
				}
			}
		}	
		return;
	}

}
