import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1075.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int num = n/100*100;
		int result = (num/m*m);
		if(num%m!=0){
			result+=m;
		}
		String str = Integer.toString(result);
		System.out.println(str.substring(str.length()-2));
		
		sc.close();
	}
}