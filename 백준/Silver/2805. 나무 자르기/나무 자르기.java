import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long max=0;
		long min=0;
		long sum=0;
		
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int h = Integer.parseInt(st.nextToken());
			tree[i] = h;
			if(max<h) {
				max=h;
			}
		}
		
		long mid=0;
		long result = 0;
		while(min<=max) {
			mid = (max+min)/2;
			sum=0;
			for(int i=0;i<N;i++) {
				if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
			}
			if(sum>=M) {
				result = mid;
				min=mid+1;
			}
			else {
				max = mid-1;
			}
			
		}
		
		System.out.println(result);
	}
	
}
