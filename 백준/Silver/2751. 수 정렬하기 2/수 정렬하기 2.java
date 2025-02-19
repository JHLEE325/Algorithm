import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("2751.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		StringBuilder str = new StringBuilder();
		
		for(int a : arr) {
			str.append(a+"\n");
		}
		
		System.out.println(str);
		
		sc.close();
	}
}