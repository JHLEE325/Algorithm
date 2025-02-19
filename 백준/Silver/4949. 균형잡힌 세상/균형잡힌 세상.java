import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine(),"\n");
			String str = st.nextToken();
			Deque<Character> list = new LinkedList<>();
			if(str.equals("."))break;
			if(str.charAt(str.length()-1)!='.') {
				sb.append("no\n");
				continue;
			}
			boolean chk = true;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(')list.push(str.charAt(i));
				else if(str.charAt(i)==')') {
					if(list.size()==0||list.peek()!='(') {
						chk = false;
						break;
					}
					list.poll();
				}
				else if(str.charAt(i)=='[')list.push(str.charAt(i));
				else if(str.charAt(i)==']'){
					if(list.size()==0||list.peek()!='[') {
						chk = false;
						break;
					}
					list.poll();
				}
			}
			if(chk&&list.size()==0)sb.append("yes\n");
			else sb.append("no\n");
		}
		
		System.out.println(sb);
	}

}