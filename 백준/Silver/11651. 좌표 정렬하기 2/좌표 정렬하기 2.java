import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] num = new int[T][2];
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]-o2[1]!=0) {
					return o1[1]-o2[1];
				}
				else {
					return o1[0]-o2[0];
				}
			}
			
		});
		
		for (int i = 0; i < T; i++) {
			System.out.println(num[i][0]+" "+num[i][1]);
		}
	}

}