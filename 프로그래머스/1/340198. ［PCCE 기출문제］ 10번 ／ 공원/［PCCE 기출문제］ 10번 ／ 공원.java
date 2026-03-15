import java.util.*;

class Solution {
    
    int n, m;
    String[][] map;
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int max = 0;
        
        this.map = park;
        this.n = park.length;
        this.m = park[0].length;
        
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < m ; j++){
                if (map[i][j].equals("-1")){
                    max = Math.max(calc(i, j), max);
                }
            }
        }
        
        for (int i = 0 ; i < mats.length ; i++){
            if (mats[i] > max) continue;
            answer = Math.max(mats[i], answer);
        }
        return answer;
    }
    
    public int calc(int r, int c){
        int size = 1;
        while (calc2(r, c , size)){
            size++;
        }
        return size - 1;
    }
    
    public boolean calc2(int r, int c, int size){
        for (int i = r ; i < r + size ; i++){
            for (int j = c ; j < c + size ; j++){
                if (i >= n || j >= m) return false;
                if (!map[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}