import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] remove;
    static int m, n;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        this.m = m;
        this.n = n;
        
        map = new char[m][n];
        remove = new boolean[m][n];
        visited = new boolean[m][n];
        
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0; j < n ; j ++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        int[] arr = new int[n];
        
        while (canRemove()){
            for (int j = 0 ; j < n ; j ++){
                for (int i = 0 ; i < m ; i++){
                    if(remove[i][j]) {
                        answer++;
                        for (int q = i; q > 0; q--){
                            map[q][j] = map[q-1][j];
                        }
                        
                        arr[j]++;
                    }
                }
                
                for (int i = 0 ; i < arr[j]; i ++){
                    visited[i][j] = true;
                }
            }
            remove = new boolean[m][n];
        }
        
        
        return answer;
    }
    
    public static boolean canRemove(){
        int cnt = 0;
        for (int i = 0; i < m - 1; i ++){
            for (int j = 0 ; j < n - 1; j++){
                if(visited[i][j] || visited[i][j+1] || visited[i+1][j] || visited[i+1][j+1]) continue;
                if(map[i][j] != map[i][j+1]) continue;
                if(map[i][j] != map[i+1][j]) continue;
                if(map[i][j] != map[i+1][j+1]) continue;
                remove[i][j] = true;
                remove[i][j+1] = true;
                remove[i+1][j] = true;
                remove[i+1][j+1] = true;
                cnt++;
            }
        }
        return cnt != 0;
    }
}