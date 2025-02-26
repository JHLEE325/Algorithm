import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> nohear = new HashMap<>();
		HashMap<String, Integer> nolook = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String name = br.readLine();
			nohear.put(name, null);
		}
		
		for(int i=0;i<M;i++) {
			String name = br.readLine();
			if(nohear.containsKey(name)) {
				nolook.put(name, null);
			}
		}
		List<String> key = new ArrayList<>(nolook.keySet());
		
		Collections.sort(key);
		sb.append(nolook.size()+"\n");
		for(String s:key) {
			sb.append(s+"\n");
		}
		
		System.out.println(sb);
	}

}
