import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("4153.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int[] tri = new int[3];
			tri[0]=sc.nextInt();
			tri[1]=sc.nextInt();
			tri[2]=sc.nextInt();
			Arrays.sort(tri);
			
			if(tri[0]==0)break;
			
			if(Math.pow(tri[0], 2)+Math.pow(tri[1], 2)==Math.pow(tri[2], 2)) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
		
		sc.close();
	}
}