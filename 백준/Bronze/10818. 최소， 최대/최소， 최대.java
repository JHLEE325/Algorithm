import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("10818.txt"));
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i]=sc.nextInt();
		}
		
		Arrays.sort(num);
		
		System.out.print(num[0]+" "+num[n-1]);

		sc.close();
	}
}