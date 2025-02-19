import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1015.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int [] arr = new int[T];
		boolean [] check = new boolean[T];
		int [] result = new int[T];
		
		for(int i=0;i<T;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<T;i++) {
			int temp = 1001;
			int idx=0;
			for(int j=0;j<T;j++) {
				if(temp>arr[j]&&!check[j]) {
					temp=arr[j];
					idx=j;
				}
			}
			result[idx]=i;
			check[idx]=true;
		}
		
		for(int a:result) {
			System.out.print(a+" ");
		}
		
		sc.close();
	}
}