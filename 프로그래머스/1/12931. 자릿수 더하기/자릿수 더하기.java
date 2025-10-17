import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=8;i>=0;i--){
            int m = (int)Math.pow(10,i);
            answer +=n/m;
            n=n%m;
        }

        return answer;
    }
}