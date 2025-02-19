import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("2908.txt"));
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		String RA = new StringBuilder(A).reverse().toString();
		String RB = new StringBuilder(B).reverse().toString();
		
		int reverseA = Integer.parseInt(RA);
		int reverseB = Integer.parseInt(RB);
		
		if(reverseA>reverseB) {
			System.out.print(reverseA);
		}
		else {
			System.out.print(reverseB);
		}
		
		sc.close();

	}

}