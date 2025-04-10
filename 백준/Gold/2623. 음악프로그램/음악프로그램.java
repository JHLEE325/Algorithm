import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}

		int[] inedge = new int[v + 1];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int[] arr = new int[cnt];
			for (int j = 0; j < cnt; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < cnt - 1; j++) {
				list.get(arr[j]).add(arr[j + 1]);
				inedge[arr[j + 1]]++;
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= v; i++) {
			if (inedge[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);
			
			for (int next : list.get(cur)) {
                if (--inedge[next] == 0) {
                    q.add(next);
                }
            }
		}
		
		if(res.size()==v) {
			for(int a:res) {
				System.out.println(a);
			}
		}
		else {
			System.out.println("0");
		}
	}

}
