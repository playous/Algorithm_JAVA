import java.util.*;

class Solution {
    
    int n;
    int[] times;
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        this.n = n;
        this.times = times;
        
        long left = 1;
        long right = 10000000000000L;
        
        while (left < right){
            long mid = (right + left) / 2;
            
            if (check(mid)){
                right = mid;
                answer = right;
            }
            else {
                left = mid + 1;   
            }
        }
        
        return answer;
    }
    
    public boolean check(long time){
        long people = 0;
        
        for (int i = 0; i < times.length; i ++){
            people += (time / times[i]);
        }
        
        return people >= n;
    }
}