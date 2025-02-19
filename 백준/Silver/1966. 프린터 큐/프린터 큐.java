import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static class Print {
        int num;
        int priority;

        public Print(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken()); 

            LinkedList<Print> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                list.add(new Print(i, Integer.parseInt(st.nextToken())));
            }

            Print target = list.get(m);
            int idx = 0;
            while(true) {
                Print current = list.poll();
                boolean isPrint = true;
                for(int i = 0; i < list.size(); i++) {
                    if(current.priority < list.get(i).priority) {
                        list.add(current);
                        isPrint = false;
                        break;
                    } 
                    
                }
                if(isPrint) {
                    idx++;
                    if(current.num == target.num && current.priority == target.priority) {
                        break;
                    }
                }
            }
            System.out.println(idx);
        }
        
    }

}
