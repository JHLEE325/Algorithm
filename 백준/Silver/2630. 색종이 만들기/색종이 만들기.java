import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] paper;
	static int blue, white;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}

	public static void cut(int starty, int startx, int n) {
		int bluecnt=0,whitecnt=0;
		for(int i=starty;i<starty+n;i++) {
			for(int j=startx;j<startx+n;j++) {
				if(paper[i][j]==1)
					bluecnt++;
				else
					whitecnt++;
			}
		}
		if(bluecnt==0) {
			white++;
			return;
		}
		else if(whitecnt==0) {
			blue++;
			return;
		}
		else {
			cut(starty, startx, n/2);
			cut(starty, startx+n/2, n/2);
			cut(starty+n/2, startx, n/2);
			cut(starty+n/2, startx+n/2, n/2);
		}
	}
	
}
