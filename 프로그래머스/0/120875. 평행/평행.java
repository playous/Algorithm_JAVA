import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[][] dots) {
        check(dots[0],dots[1],dots[2],dots[3]);
        check(dots[0],dots[2],dots[1],dots[3]);
        check(dots[0],dots[3],dots[1],dots[2]);
        
        return answer;
    }
    void check (int[] a1, int[] a2 ,int[] b1, int[] b2){
        int dx1 = a1[0] - a2[0];
        int dy1 = a1[1] - a2[1];
        int dx2 = b1[0] - b2[0];
        int dy2 = b1[1] - b2[1];
        if(dx1 * dy2 == dx2 * dy1) answer = 1;
    }
}