import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("10250.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			int room_h;
			int room_w;
			if(n%h==0) {
				room_w=n/h;
				room_h=h*100;
			}
			else {
				room_w=n/h+1;
				room_h=n%h*100;
			}
			int result = room_h+room_w;
			
			System.out.println(result);
		}

		sc.close();
	}
}
