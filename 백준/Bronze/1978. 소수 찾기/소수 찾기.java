import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1978.txt"));
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int count=0;
		
		for(int i=0;i<num;i++) {
			boolean a = false;
			int check=sc.nextInt();
			int max = check-1;
			//System.out.println(max);
			for(int j=max;j>=2;j--) {
				if(check%j==0) {
					a=true;
					break;
				}
			}
			if(!a&&check!=1) {
				count++;
			}
		}
		System.out.println(count);
		
		sc.close();
	}
}