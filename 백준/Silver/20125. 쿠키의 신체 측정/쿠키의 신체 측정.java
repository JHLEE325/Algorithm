import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		char[][] cookie = new char[num][num];
		for (int i = 0; i < num; i++) {
			cookie[i] = br.readLine().toCharArray();
		}

		int heartx = 0, hearty = 0;
		boolean findheart = false;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (cookie[i][j] == '*') {
					findheart = true;
					heartx = j;
					hearty = i + 1;
				}
			}
			if (findheart) {
				break;
			}
		}
		int larm = 0, rarm = 0, lleg = 0, rleg = 0, back = 0;
		
		for(int i=0;i<heartx;i++) {
			if(cookie[hearty][i]=='*') {
				larm++;
			}
		}
		
		for(int i=heartx+1;i<num;i++) {
			if(cookie[hearty][i]=='*') {
				rarm++;
			}
		}
		
		for(int i=hearty+1;i<num;i++) {
			if(cookie[i][heartx]=='*') {
				back++;
			}
		}
		
		for(int i=hearty+1;i<num;i++) {
			for(int j=0;j<heartx;j++) {
				if(cookie[i][j]=='*') {
					lleg++;
				}
			}
		}
		
		for(int i=hearty+1;i<num;i++) {
			for(int j=heartx+1;j<num;j++) {
				if(cookie[i][j]=='*') {
					rleg++;
				}
			}
		}
		
		System.out.println((hearty+1) +" "+(heartx+1)+"\n"+larm+" "+rarm+" "+back+" "+lleg+" "+rleg);
	}

}
