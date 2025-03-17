import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] friend = new int[n+1][n+1];
		boolean[] ischk = new boolean[n+1];
		ischk[1]=true;
		List<Integer>list = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friend[a][b]=1;
			friend[b][a]=1;
		}
		
		int count=0;
		for(int i=2;i<=n;i++) {
			if(friend[1][i]==1) {
				count++;
				list.add(i);
				ischk[i]=true;
			}
		}
		for(int a:list) {
			for(int i=2;i<=n;i++) {
				if(friend[a][i]==1&&!ischk[i]) {
					count++;
					ischk[i]=true;
				}
			}
		}
		
		System.out.println(count);
	}

}
