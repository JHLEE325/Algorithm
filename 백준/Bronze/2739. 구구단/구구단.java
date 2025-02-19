import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("2739.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.println(n+" * "+i+" = "+n*i);
		}
		
		
		sc.close();
	}

}