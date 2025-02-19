import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("2609.txt"));
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd=0;

		for (int i = 1; i <= a && i <= b; i++) {
			if(a%i==0&&b%i==0) {
				gcd=i;
			}
		}
		
		int lcm = a*b/gcd;
		System.out.println(gcd);
		System.out.println(lcm);

		sc.close();
	}
}