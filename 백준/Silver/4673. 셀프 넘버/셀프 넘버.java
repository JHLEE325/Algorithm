import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean[] self = new boolean[10001];

        for(int i=1;i<10001;i++){
            if(!self[i]){
                sb.append(i+"\n");
            }
            int num=i;
            int temp=0;
            temp+=num;
            temp+=num/1000;
            num=num%1000;
            temp+=num/100;
            num=num%100;
            temp+=num/10;
            num=num%10;
            temp+=num;
            if(temp>10000)
                continue;
            self[temp] = true;
        }
        System.out.println(sb.toString());
    }
}
