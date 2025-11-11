import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int answer = 0;
    
    public int solution(int n) {
        N = n;
        
        int[] map = new int[n];
        calc(map,0);
        
        return answer;
    }
    static void calc(int[] map,int row){
        if (row == N){
            answer++;
            return;
        }
        for (int col = 0; col < N ; col ++){
            if (check(map, row, col)){
                map[row] = col;
                calc(map, row + 1);
            }
        }
    }
    static boolean check(int[] map, int row, int col){
        for (int i = 0 ; i < row ; i++){
            if (map[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(map[i] - col)) return false;
        }
        return true;
    }
}