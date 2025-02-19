import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("1157.txt"));
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		s=s.toUpperCase();
		//System.out.println(s);
		
		char[] c = {'A','B','C','D','E','F','G','H','I','J'
				,'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int[] a = new int[c.length];
		boolean[] b = new boolean[s.length()];
		
		//TODO:증가하는 index가 잘못됨
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<c.length;j++) {
				if(c[j]==s.charAt(i)) {
					a[j]++;
				}
			}
		}
		
		int midx = 0;
		int tmp=0;
		boolean same = false;
		
		for(int i=0;i<c.length;i++) {
			if(tmp<a[i]) {
				tmp=a[i];
				midx=i;
				same=false;
			}
			else if(tmp==a[i]) {
				same=true;
			}
		}
		
		if(same) {
			System.out.print("?");
		}
		else {
			System.out.print(c[midx]);
		}
		
		sc.close();

	}
}