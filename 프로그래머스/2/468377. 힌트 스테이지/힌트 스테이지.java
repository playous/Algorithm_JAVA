import java.util.*;

class Solution {
    
    int[][] cost;
    int[][] hint;
    
    int[] hintNum;
    
    int n, k;
    
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        
        this.n = cost.length;
        this.k = cost[0].length;
        
        this.hintNum = new int[n];
        this.cost = cost;
        this.hint = hint;     
                
        calc(0, 0);
        return answer;
    }
    
    public void calc(int stage, int sum){
        if (stage == n - 1){
            int h = Math.min(hintNum[stage], k - 1);
            answer = Math.min(answer, sum + cost[stage][h]); 
            return;
        }
        
        int h = Math.min(hintNum[stage], k - 1);
        
        for (int i = 1; i < hint[stage].length; i ++){
            hintNum[hint[stage][i] - 1]++;
        }
        calc(stage + 1,  sum + hint[stage][0] + cost[stage][h]);
        
        for (int i = 1; i < hint[stage].length; i ++){
            hintNum[hint[stage][i] - 1]--;
        }
                
        calc(stage + 1,  sum + cost[stage][h]);
        
        
    }
}