import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L,C;
	static char[] characters, res;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		characters = new char[C];
		res = new char[L];
		isSelected = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			characters[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(characters);
		
		permutation(0,0);
	}

	
	public static void permutation(int cnt, int start) {
		if(cnt==L) {
			boolean ismoem=false;
			int jaem=0;
			for(char a:res) {
				if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u') {
					ismoem=true;
				}
				else {
					jaem++;
				}
			}
			if(ismoem&&jaem>=2) {
				for(char a:res) {
					System.out.print(a);
				}
				System.out.println();
			}
			
			return;
		}
		
		for(int i=start;i<C;i++) {
			if(isSelected[i])
				continue;
			
			isSelected[i] = true;
			res[cnt] = characters[i];
			permutation(cnt + 1, i+1);
			isSelected[i] = false;
		}
	}
}