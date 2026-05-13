import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int left = 1; 
        int right = 200000000;
        
        while (left < right){
            int mid = (left + right) / 2;
            
            if (canJump(stones, mid, k)){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        int answer = left;

        return answer;
    }
    
    public boolean canJump(int[] stones, int mid, int k){
        int count = 0;
        for (int stone : stones){
            if (stone <= mid){
                count++;
                if (count >= k) return false;
            }
            else {
                count = 0;
            }
        }
        return true;
    }
}