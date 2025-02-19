import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1110.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = -1;
		int step=n;
		int count=0;
		while(num!=n) {
			num=step%10*10;
			step = step/10+step%10;
			num+= step%10;
			step=num;
			count++;
		}
		
		System.out.println(count);
		
		sc.close();
	}

}