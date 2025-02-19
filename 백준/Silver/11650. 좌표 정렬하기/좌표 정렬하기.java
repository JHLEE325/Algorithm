import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("11650.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] num = new int[n][2];

		for (int i = 0; i < n; i++) {
			num[i][0] = sc.nextInt();
			num[i][1] = sc.nextInt();
		}
		
		Arrays.sort(num, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]-o2[0]!=0) {
					return o1[0]-o2[0];
				}
				else {
					return o1[1]-o2[1];
				}
			}
			
		});
		
		for (int i = 0; i < n; i++) {
			System.out.println(num[i][0]+" "+num[i][1]);
		}

		sc.close();
	}
}