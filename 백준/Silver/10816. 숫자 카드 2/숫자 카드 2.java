import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		int[] arr2 = new int[M];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			map.put(a, 0);
			arr2[i]=a;
		}
		
		for(int i=0;i<N;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		StringBuilder str = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			str.append(map.get(arr2[i])+" ");
		}
		
		System.out.println(str);
	}

}
