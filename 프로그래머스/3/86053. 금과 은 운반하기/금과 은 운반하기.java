import java.util.*;

class Solution {
    int gold, sliver, n;
    
    int[] g,s,w,t;
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long answer = 0;
        
        this.gold = a;
        this.sliver = b;
        this.n = g.length;
        
        this.g = g;
        this.s = s;
        this.w = w;
        this.t = t;
        
        long right = 400000000000000L;
        long left = 0;
        
        while (left <= right){
            long mid = (right + left) / 2;
            
            boolean canMove = calc(mid);
            
            if(canMove) {
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        
        return answer;
    }
    
    public boolean calc(long time){
        long maxGold = 0;
        long maxSliver = 0;
        long maxMineral = 0;
        
        
        for (int i = 0 ; i < n ; i ++){
            long count = time / (t[i] * 2);
            if (time % (t[i] * 2) >= t[i]) count++;
            
            maxGold += Math.min(w[i] * count, g[i]);
            maxSliver += Math.min(w[i] * count, s[i]);
            maxMineral += Math.min(g[i] + s[i], w[i] * count);
        }
        
        if(maxGold >= gold && maxSliver >= sliver && maxMineral >= gold + sliver){
            return true;
        }
        return false;
    }
}