import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[] arr = new int[num];
		
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		
		for(int a:arr) {
			sb.append(a+"\n");
		}
		
		System.out.println(sb);
	}

}