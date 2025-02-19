import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int[][] chk = new int[30][30];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1010.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//System.out.println(T);
		
		for(int test = 0; test<T; test++) {
			int result = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n==m) {
				result = 1;
			}
			else {
				result = combination(m,n);
			}
			
			System.out.println(result);
		}  
		
		sc.close();
	}
	
	public static int combination(int m, int n) {
		if(m == n || n == 0) 
			return 1;
		if(chk[m][n]!=0)
			return chk[m][n];
		else 
			return chk[m][n] = combination(m - 1, n - 1) + combination(m - 1, n); 
	}

}