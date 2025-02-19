import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1037.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		
		int result=0;
		if(n==1) {
			result = a[0]*a[0];
		}
		else {
			result = a[0]*a[a.length-1];
		}
		
		System.out.println(result);
		
		sc.close();
	}
}