import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        int a1 = 0, a2 = 0, y = 0;
        boolean flag = false;
        
        for (int x = 3 ; x <= sum / 3 ; x ++){
            if (sum % x == 0){
                y = sum / x;
                if((x - 2) * (y - 2) == yellow){
                    flag = true;
                }
            }
            if (flag){
                a1 = Math.max(x, y);
                a2 = Math.min(x, y);
                break;
            }
        }
        
        answer[0] = a1;
        answer[1] = a2;
        
        return answer;
    }
}