import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1085.txt"));
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int[] result = {x,y,w-x,h-y};
		
		Arrays.sort(result);
		System.out.println(result[0]);
		
		sc.close();
	}

}