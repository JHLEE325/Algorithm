import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("11720.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int num=0;
		for(int i=0;i<n;i++) {
			num+=Integer.valueOf(str.charAt(i))-'0';
		}
		System.out.println(num);

		sc.close();
	}
}