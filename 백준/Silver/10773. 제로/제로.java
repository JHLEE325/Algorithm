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

		int T = Integer.parseInt(st.nextToken());
		
		Deque<Integer> list = new LinkedList<>();

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			
			if(tmp==0) {
				list.poll();
			}
			else {
				list.push(tmp);
			}
		}
		int sum=0;
		for(int a:list) {
			sum+=a;
		}
		
		System.out.println(sum);
	}

}