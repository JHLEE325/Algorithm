import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1018.txt"));
		Scanner sc = new Scanner(System.in);
		String[] s1 = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};
		String[] s2 = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};
		int M = sc.nextInt();
		int N = sc.nextInt();
		String[] chess = new String[M];
		for(int i=0;i<M;i++) {
			chess[i] = sc.next();;
		}

		int count = 64;
		for(int i=0;i<=M-8;i++) {
			for(int j=0;j<=N-8;j++) {
				int num1=0;
				int num2=0;
				for(int a=0;a<8;a++) {
					for(int b=0;b<8;b++) {
						if(chess[a+i].charAt(j+b)!=s1[a].charAt(b)) {
							num1++;
						}
						if(chess[a+i].charAt(j+b)!=s2[a].charAt(b)) {
							num2++;
						}
					}
				}
				if(num1>=num2) {
					if(count>num2)
						count=num2;
				}
				else if(num2>num1) {
					if(count>num1)
						count=num1;
				}
			}
		}
		System.out.println(count);

		sc.close();
	}
}