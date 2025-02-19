import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("11718.txt"));
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			if(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			else {
				break;
			}
		}

	}

}