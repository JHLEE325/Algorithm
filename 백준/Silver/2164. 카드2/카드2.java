import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> list = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		
		int add=1;
		while(list.size()!=1) {
			list.poll();
			add = list.poll();
			list.add(add);
		}
		
		System.out.println(add);
	}
}