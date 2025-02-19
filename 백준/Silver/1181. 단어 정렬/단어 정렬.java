import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1181.txt"));
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String[] str = new String[num];
		
		for(int i=0;i<num;i++) {
			str[i]=sc.next();
		}
		Arrays.sort(str);
		
		Arrays.sort(str,(String s1, String s2)->s1.length()-s2.length());
		
		List<String> list = new ArrayList<>();
		
		for(String s:str) {
			if(!list.contains(s)) {
				list.add(s);
			}
		}
		
		for(String s:list) {
			System.out.println(s);
		}
		sc.close();
	}
}