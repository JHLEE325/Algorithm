import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("10951.txt"));
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			System.out.println(a+b);
		}

		sc.close();
	}

}
