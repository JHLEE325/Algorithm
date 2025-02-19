import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1049.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] maker = new int[m][2];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<2;j++) {
				maker[i][j]=sc.nextInt();
			}
		}
		
		int set = n/6;
		if(n%6!=0) {
			set+=1;
		}
		int minset=1000;
		int minone=1000;
		int[] result = new int[3];
		for(int i=0;i<m;i++) {
			if(minset>maker[i][0]) {
				minset=maker[i][0];
			}
			if(minone>maker[i][1]) {
				minone=maker[i][1];
			}
		}
		result[0]=minset*set;
		result[1]=minone*n;
		result[2]=minset*(n/6)+minone*(n%6);
		
		Arrays.sort(result);
		
		System.out.println(result[0]);
		
		sc.close();
	}
}