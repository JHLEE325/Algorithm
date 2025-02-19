import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int answer=-1;
		if(num%5==0) {
			answer=num/5;
		}
		else if((num-3)%5==0&&(num-3)>=0) {
			answer = (num-3)/5 + 1;
		}
		else if((num-6)%5==0&&(num-6)>=0) {
			answer = (num-6)/5 + 2;
		}
		else if((num-9)%5==0&&(num-9)>=0) {
			answer = (num-9)/5 + 3;
		}
		else if((num-12)%5==0&&(num-12)>=0) {
			answer = (num-12)/5 + 4;
		}
		else if((num-5)%3==0&&(num-5)>=0) {
			answer = (num-5)/3 + 1;
		}
		else if((num-10)%3==0&&(num-10)>=0) {
			answer = (num-5)/3 + 2;
		}
		
		System.out.println(answer);
	}

}