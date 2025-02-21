import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] numbers;
	static int num, flavor;
	static int[] score;
	static int[] sour;
	static int[] bitter;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		num = Integer.parseInt(st.nextToken());
		sour = new int[num];
		bitter = new int[num];
		flavor = Integer.MAX_VALUE;

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		food(0,0,1,0);
		System.out.println(flavor);
	}
	
	public static void food(int cnt, int elements, int s, int b) {
		
		if(cnt==num) {
			if(elements!=0) {
				int tmp = Math.abs(b-s);
				if(flavor>tmp) {
					flavor=tmp;
				}
			}
			
			return;
		}
		
		food(cnt+1,elements+1,s*sour[cnt],b+bitter[cnt]);
		
		food(cnt+1,elements,s,b);
	}

}
