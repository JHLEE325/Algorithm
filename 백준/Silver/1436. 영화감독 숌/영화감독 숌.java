import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int idx=0;
		int start=665;
		while(true) {
			String chk = String.valueOf(start);
			if(chk.contains("666")) {
				idx++;
				if(idx==num) {
					break;
				}
			}
			
			start++;
		}
		
		System.out.println(start);
	}

}