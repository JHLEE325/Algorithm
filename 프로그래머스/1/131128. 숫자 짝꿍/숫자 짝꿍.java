import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xarr = new int[10];
        int[] yarr = new int[10];
        
        for(int i=0; i<X.length(); i++){
            xarr[X.charAt(i) - '0']++;
        }
        for(int i=0; i<Y.length(); i++){
            yarr[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=9; i>=0; i--){
            int size = Math.min(xarr[i], yarr[i]);
            for(int j=0; j<size; j++){
                sb.append(i);
            }
        }
                
        String answer = sb.toString();
        
        if (answer.isEmpty()) {
            return "-1";
        }
        
        if (answer.startsWith("0")) {
            return "0";
        }
        
        return answer;
    }
}