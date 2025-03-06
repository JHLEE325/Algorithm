import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(minHeap.size()==0) {
					sb.append("0\n");
				}
				else {
					sb.append(minHeap.poll()+"\n");
				}
			}
			else {
				minHeap.add(x);
			}
		}
		
		System.out.println(sb);
	}

}
