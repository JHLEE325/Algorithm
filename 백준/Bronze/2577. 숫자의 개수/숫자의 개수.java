import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("10250.txt"));
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] cnt = new int[10];

		long mul = a * b * c;
		int num = (int) (Math.log10(mul));

		for (int i = num; i >= 0; i--) {
			int divide = (int) Math.pow(10, i);
			cnt[(int) (mul/divide)]++;
			mul=mul%divide;
		}
		
		for(int i:cnt) {
			System.out.println(i);
		}

		sc.close();
	}
}