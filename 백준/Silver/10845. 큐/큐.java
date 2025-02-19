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
		
		int num = Integer.parseInt(st.nextToken());
		Deque<Integer> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
			case "push":
				int tmp = Integer.parseInt(st.nextToken());
				list.push(tmp);
				continue;
			case "pop":
				if(list.size()!=0) {
					sb.append(list.pollLast()+"\n");
				}
				else {
					sb.append("-1\n");
				}
				continue;
			case "size":
				sb.append(list.size()+"\n");
				continue;
			case "empty":
				if(list.size()!=0) {
					sb.append("0\n");
				}
				else {
					sb.append("1\n");
				}
				continue;
			case "front":
				if(list.size()!=0) {
					sb.append(list.peekLast()+"\n");
				}
				else {
					sb.append("-1\n");
				}
				continue;
			case "back":
				if(list.size()!=0) {
					sb.append(list.peek()+"\n");
				}
				else {
					sb.append("-1\n");
				}
				continue;
			}
		}
		System.out.println(sb);
	}

}