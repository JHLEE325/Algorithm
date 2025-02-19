import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		int[][] people = new int[T][2];
		int[] rank = new int[T];
		Arrays.fill(rank, 1);

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			people[t][0]=Integer.parseInt(st.nextToken());
			people[t][1]=Integer.parseInt(st.nextToken());
		}
		int idx=0;
		for(int[] a : people) {
			for(int[] b : people) {
				if(a[0]<b[0]&&a[1]<b[1]) {
					rank[idx]++;
				}
			}
			idx++;
		}
		
		for(int a : rank) {
			System.out.print(a+" ");
		}
	}

}