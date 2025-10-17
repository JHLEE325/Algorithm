import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        for(int i=0;i<24;i++){
            if(players[i]>=m){
                int temp = players[i]/m;
                for(int j=0;j<k;j++){
                    if(i+j>=24)
                        continue;
                    players[i+j]-=m*temp;
                }
                answer+=temp;
            }
        }
        return answer;
    }
}