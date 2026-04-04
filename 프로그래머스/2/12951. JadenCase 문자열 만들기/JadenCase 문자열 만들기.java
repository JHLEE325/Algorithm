import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();

            if (tmp.equals(" ")) {
                sb.append(tmp);
                continue;
            }

            char c = tmp.charAt(0);
            if (c >= 'a' && c <= 'z') {
                c -= 32;
            }

            sb.append(c).append(tmp.substring(1).toLowerCase()); 
        }

        return sb.toString();
    }
}