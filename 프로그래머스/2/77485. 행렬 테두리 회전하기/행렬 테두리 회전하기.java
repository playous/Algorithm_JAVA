import java.util.*;

class Solution {
    
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int n = queries.length;
        int[] answer = new int[n];

        map = new int[rows + 1][columns +1];
        
        int num = 1;
        for (int i = 1; i <= rows; i ++){
            for (int j = 1; j <= columns; j++){
                map[i][j] = num++;
            }
        }        
        
        int idx = 0;
        
        for (int[] arr : queries){
            int min = calc(arr[0], arr[1], arr[2], arr[3]);
            answer[idx++] = min;
        }
        
        return answer;
    }
    
    
    public int calc(int r1, int c1, int r2, int c2){
        int temp = map[r1][c2];
        
        int min = temp;
        
        for (int j = c2; j > c1; j --){
            map[r1][j] = map[r1][j - 1];
            min = Math.min(min, map[r1][j]);
        }
        
        int temp2 = map[r2][c2];
        
        for (int i = r2; i > r1 ; i --){
            map[i][c2] = map[i - 1][c2];
            if (i == r1 + 1){
                map[i][c2] = temp;
            }
            min = Math.min(min, map[i][c2]);
        }
        
        int temp3 = map[r2][c1];
        
        for (int j = c1;  j < c2; j ++){
            map[r2][j] = map[r2][j + 1];
            if (j == c2 - 1){
                map[r2][j] = temp2;
            }
            min = Math.min(min, map[r2][j]);
        }
        
        for (int i = r1; i < r2; i ++){
            map[i][c1] = map[i + 1][c1];
            if (i == r2 - 1){
                map[i][c1] = temp3;
            }
            min = Math.min(min, map[i][c1]);
        }
        
        return min;
    }
}