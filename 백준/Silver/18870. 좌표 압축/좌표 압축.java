import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] list = arr.clone();
		Arrays.sort(list);
		
		Map<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		
		for(int i=0;i<n;i++) {
			if(!map.containsKey(list[i])) {
				map.put(list[i], rank++);
			}
		}
		
		for(int a:arr) {
			sb.append(map.get(a)+" ");
		}

		System.out.println(sb);
	}

}
