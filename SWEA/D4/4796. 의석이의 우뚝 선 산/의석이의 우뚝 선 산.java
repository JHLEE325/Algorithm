import java.util.Scanner;

public class Solution {

	static int N, result;
	static int[] mountain;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			mountain = new int[N];
			isSelected = new boolean[N];
			result = 0;

			for (int i = 0; i < N; i++) {
				mountain[i] = sc.nextInt();
			}
			
			int[][] chk = new int[2][N];
			
			for(int i=1;i<N-1;i++) {
				if(mountain[i]>mountain[i-1]) {
					chk[0][i]=chk[0][i-1]+1;
				}
				else {
					chk[0][i]=0;
				}
			}
			
			for(int i=N-2;i>=1;i--) {
				if(mountain[i]>mountain[i+1]) {
					chk[1][i]=chk[1][i+1]+1;
				}
				else {
					chk[1][i]=0;
				}
			}
			
			for(int i=0;i<N;i++) {
				result+=chk[0][i]*chk[1][i];
			}
			
			sb.append("#"+t+" "+result+"\n");
			
		}
		System.out.println(sb);
	}

}
