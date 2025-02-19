import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("9012.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			String s = sc.next();
			char[] c = s.toCharArray();
			
			int num=0;
			for(int k=0;k<c.length;k++) {
				if(c[k]=='(') {
					num++;
				}
				else {
					num--;
				}
				
				if(num<0) {
					System.out.println("NO");
					break;
				}
			}
			
			if(num>0) {
				System.out.println("NO");
			}
			else if(num==0) {
				System.out.println("YES");
			}
		}
		
		sc.close();

	}

}