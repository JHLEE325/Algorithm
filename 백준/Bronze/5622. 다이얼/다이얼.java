import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("5622.txt"));
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		//System.out.println(s);

		char[] c = s.toCharArray();

		int num=0;

		for(char tmp : c) {
			switch(tmp) {
                case 'A': case'B': case'C':
				num+=3;
				break;
                case 'D': case'E': case'F':
				num+=4;
				break;
                case 'G': case'H': case'I':
				num+=5;
				break;
                case 'J': case'K': case'L':
				num+=6;
				break;
                case 'M': case'N': case'O':
				num+=7;
				break;
                case 'P': case'Q': case'R': case'S':
				num+=8;
				break;
                case 'U': case'T': case'V':
				num+=9;
				break;
                case 'Y': case'W': case'X': case'Z':
				num+=10;
				break;
			default:
                num+=2;
				break;

			}
		}
		System.out.print(num);



	}

}