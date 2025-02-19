import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Integer> list = new HashSet<>();
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		
		int m=sc.nextInt();
		StringBuilder str = new StringBuilder();
		for(int i=0;i<m;i++) {
			if(list.contains(sc.nextInt())) {
				str.append("1\n");
			}
			else {
				str.append("0\n");
			}
		}
		
		System.out.println(str);

		sc.close();
	}
}