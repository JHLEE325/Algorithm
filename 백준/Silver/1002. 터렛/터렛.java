import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1002.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//System.out.println(T);
		
		for(int test = 0; test<T; test++) {
			int[] num = new int[6];
			int result=0;
			
			for(int i=0;i<6;i++) {
				num[i]=sc.nextInt();
			}
			
			int x = Math.abs(num[0]-num[3]);
			int y = Math.abs(num[1]-num[4]);
			double distance = Math.hypot(x, y);
			
			if(num[0]==num[3]&&num[1]==num[4]) {
				if(num[2]==num[5]) {
					result=-1;
				}
				else {
					result=0;
				}
			}
			
			else {
				if(distance>num[2]+num[5]) {
					result=0;
				}
				else if(distance==num[2]+num[5]||distance==Math.abs(num[2]-num[5])) {
					result=1;
				}
				else if(distance<num[2]+num[5]&&distance>Math.abs(num[2]-num[5])) {
					result=2;
				}
				else {
					result=0;
				}
			}
			System.out.println(result);
		}
		
		sc.close();
	}

}
