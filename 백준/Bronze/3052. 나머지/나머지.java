import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("3052.txt"));
		Scanner sc = new Scanner(System.in);
		
		boolean[] cnt = new boolean[42];
		
		for(int i=0;i<10;i++) {
			int num = sc.nextInt();
			cnt[num%42]=true;
		}
		
		int count=0;
		for(int i=0;i<42;i++) {
			if(cnt[i])count++;
		}
		
		System.out.println(count);

		sc.close();
	}
}