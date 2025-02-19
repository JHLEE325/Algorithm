import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> list = new LinkedList<>();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
		
		while(list.size()>1) {
			for(int i=1;i<k;i++) {
				list.add(list.poll());
			}
			sb.append(list.poll()+", ");
		}
		
		sb.append(list.poll()+">");
		
		System.out.println(sb);
	}

}