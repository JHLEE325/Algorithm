import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int[] n1 = new int[41];
    static int[] n2 = new int[41];

    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("1003.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            fibo(num);
        }
        System.out.println(sb);
        
        sc.close();
    }

    static void fibo(int num) {
        n1[0] = 1;
        n2[0] = 0;
        if (n1[40] == 0) {
            for (int i = 1; i < 41; i++) {
                n1[i] = n2[i - 1];
                n2[i] = n1[i - 1] + n1[i];
            }
        }
        
        sb.append(n1[num] + " " + n2[num]).append("\n");

    }

}