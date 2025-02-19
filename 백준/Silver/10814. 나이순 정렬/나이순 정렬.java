import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("10814.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] people = new String[n][2];
		
		for(int i=0;i<n;i++) {
			String age = sc.next();
			String name = sc.next();
			people[i][0]=age;
			people[i][1]=name;
		}
		
		Arrays.sort(people, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
			
		});
		
		for(int i=0;i<n;i++) {
			System.out.println(people[i][0]+" "+people[i][1]);
		}
		
		sc.close();
	}
}