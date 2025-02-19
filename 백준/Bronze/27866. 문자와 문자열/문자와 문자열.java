import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("27866.txt"));
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = sc.nextInt();
		
		System.out.println(str.charAt(n-1));

		sc.close();
	}
}