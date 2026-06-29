import java.util.*;

class Solution {
    public class Node{
        int id;
        int endTime;
        public Node(int id, int endTime){
            this.id = id;
            this.endTime = endTime;
        }
    }
    
    int n;
    int[] cores;
    
    public int solution(int n, int[] cores) {
        this.n = n;
        this.cores = cores;
        
        int answer = 0;
        
        if (n <= cores.length) return n;
        
        this.n -= cores.length;
        
        long right = 10000 * 50000;
        long left = 1;
        
        while (left <= right){
            long mid = (right + left) / 2;
            
            if (calc(mid)){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        int remain = this.n;
        
        for (int i = 0; i < cores.length; i++) {
            remain -= (left - 1) / cores[i];
        }

        for (int i = 0; i < cores.length; i++) {
            if (left % cores[i] == 0) {
                remain--;
                if (remain == 0) {
                    answer = i + 1;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public boolean calc(long mid){
        long count = 0;
        for (int num : cores){
            count += (mid / num);
        }
        if (count >= n) return true;
        return false;
    }
}