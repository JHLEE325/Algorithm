class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        int div = s/n;
        int mod = s%n;
        if(div==0){
            answer = new int[1];
            answer[0]=-1;
        }
        else{
            answer = new int[n];
            for(int i=0;i<n;i++){
                answer[i]=div;
            }
            int idx = n-1;
            while(mod>0){
                answer[idx]+=1;
                idx--;
                mod--;
            }
        }
        return answer;
    }
}