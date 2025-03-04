import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		permutation(0,1);
	}

	
	public static void permutation(int cnt, int start) {
		if(cnt==M) {
			for(int a:numbers) {
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=N;i++) {
			numbers[cnt]=i;
			permutation(cnt+1,i);
		}
	}
}