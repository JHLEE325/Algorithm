import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr,numbers;
	static int k;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0) {
				break;
			}
			
			arr = new int[k];
			numbers = new int[6];
			for(int i=0;i<k;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			combination(0,0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void combination(int cnt, int idx) {
		if(cnt==6) {
			for(int a:numbers) {
				sb.append(a+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < k; i++) {
			numbers[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}

}