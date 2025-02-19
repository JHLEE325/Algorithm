import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1546.txt"));
		Scanner sc = new Scanner(System.in);
		
		int num=sc.nextInt();
		int[] arr = new int[num];
		double avg=0;
		
		for (int i = 0; i < num; i++) {
			arr[i]=sc.nextInt();
			avg+=arr[i];
		}
		Arrays.sort(arr);
		
		avg=avg/num;
		
		avg=avg*100/arr[num-1];
		
		System.out.println(avg);
		
		
		
		sc.close();
	}
}