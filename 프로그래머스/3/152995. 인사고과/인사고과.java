import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int len = scores.length;

        int w1 = scores[0][0];
        int w2 = scores[0][1];
        int wSum = w1 + w2;
        
        Arrays.sort(scores, (a, b) -> {
          if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int rank = 1;
        int max2 = scores[0][1];
        
        for (int i = 0 ; i < len ; i ++){
            if (scores[i][1] < max2) {
                if (scores[i][0] == w1 && scores[i][1] == w2) return -1;
                continue; 
            }
            max2 = Math.max(max2, scores[i][1]);

            if (scores[i][0] + scores[i][1] > wSum) rank++;
        }
        
        return rank;
    }
}