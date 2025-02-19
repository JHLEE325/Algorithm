import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("2798.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		
		int max=0;
		for(int a=0;a<n-2;a++) {
			for(int b=a+1;b<n-1;b++) {
				for(int c=b+1;c<n;c++) {
					int check = arr[a]+arr[b]+arr[c];
					if(check<=m&&check>max) {
						max=check;
					}
				}
			}
		}
		System.out.println(max);
		
		
		sc.close();
	}
}