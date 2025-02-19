import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] s = new String[3];
		String s1 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String s2 = st.nextToken();
		st = new StringTokenizer(br.readLine());
		String s3 = st.nextToken();
		s[0]=s1;
		s[1]=s2;
		s[2]=s3;
		String fb = "FizzBuzz";
		int idx=0;
		
		for(int i=0;i<3;i++) {
			if(fb.contains(s[i])) {
				continue;
			}
			else {
				idx=i;
				break;
			}
		}
		
		int result = Integer.parseInt(s[idx]);
		result+=3-idx;
		
		if(result%3==0&&result%5==0) {
			System.out.println("FizzBuzz");
		}
		else if(result%3==0&&result%5!=0) {
			System.out.println("Fizz");
		}
		else if(result%3!=0&&result%5==0) {
			System.out.println("Buzz");
		}
		else {
			System.out.println(result);
		}
	}

}