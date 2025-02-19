import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		Deque<Integer> list = new LinkedList<>();
		List<Integer> tmplist = new ArrayList<>();
		
		if(num==0) {
			System.out.println("0");
			return;
		}
		
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			tmplist.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(tmplist);		
		for(int a:tmplist) {
			list.push(a);
		}
		
		double k = Math.round((double)num*0.15);

		for(int i=0;i<k;i++) {
			list.pollFirst();
			list.pollLast();
		}
		
		int count=(int) (num-(k*2));
		int sum=0;
		for(int a:list)sum+=a;
		float avg = (float)sum/count;
		
		System.out.println(Math.round(avg));
	}

}