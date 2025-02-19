import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("10809.txt"));
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] chk = new int[26];
		Arrays.fill(chk, -1);
		
		for(int i=0;i<str.length();i++) {
			int idx = str.charAt(i)-'a';
			if(chk[idx]==-1) {
				chk[idx]=i;
			}
		}
		
		for(int num:chk) {
			System.out.print(num+" ");
		}
		
		sc.close();
	}
}