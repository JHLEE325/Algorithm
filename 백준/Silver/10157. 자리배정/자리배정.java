import java.io.*;
import java.util.*;

public class Main {

	static boolean[][] map;
	static int n, m, num;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new boolean[m][n];
		
		int count = n*m;
		int cnt = 1;
		num = Integer.parseInt(br.readLine());
		
		int y = m-1;
		int x = 0;
		map[y][x] = true;
		int dnum = 0;
		while(cnt<=count) {
			if(cnt==num) {
				System.out.println((x+1) + " " + (m-y));
				return;
			}
			if(cnt==count)
				break;
			int dy = y + dir[dnum][0];
			int dx = x + dir[dnum][1];
			
			if(dy<0||dy>=m||dx<0||dx>=n) {
				dnum++;
				dnum = dnum%4;
				continue;
			}
			if(map[dy][dx]) {
				dnum++;
				dnum = dnum%4;
				continue;
			}
			map[dy][dx]=true;
			y=dy;
			x=dx;
			
			cnt++;
		}
		
		System.out.println("0");
	}

}
