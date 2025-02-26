import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> list = new HashMap<>();
		HashMap<Integer, Integer> full = new HashMap<>();
		for(int i=1;i<=20;i++) {
			full.put(i, null);
		}
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int num;
			switch(s) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				list.put(num, null);
				continue;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				list.remove(num);
				continue;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(list.containsKey(num)) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
				continue;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if(list.containsKey(num)) {
					list.remove(num);
				}
				else {
					list.put(num, null);
				}
				continue;
			case "all":
				list.putAll(full);
				continue;
			case "empty":
				list.clear();
				continue;
			}
		}
		
		System.out.println(sb);
		
		
	}

}