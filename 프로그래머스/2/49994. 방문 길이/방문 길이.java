import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    
    HashSet<String> set = new HashSet<>();
    
    int[][] map = new int[11][11];
    
    public int solution(String dirs) {
        int answer = 0;
        int size = dirs.length();
        
        int sr = 5;
        int sc = 5;
        
        int br = 5;
        int bc = 5;
        
        for (int i = 0 ; i < size; i++){
            int move = change(dirs.charAt(i));
            
            int nr = sr + dr[move];
            int nc = sc + dc[move];
            
            if (nr >= 0 && nc >= 0 && nr <= 10 && nc <= 10){
                                
                br = sr;
                bc = sc;
                
                sr = nr;
                sc = nc;
                
                String memo1 = br + " " + bc + " " + sr + " " + sc;
                String memo2 = sr + " " + sc + " " + br + " " + bc;
                if (!set.contains(memo1) && !set.contains(memo2)){
                    set.add(memo1);
                    set.add(memo2);
                    answer++;
                }
            }
            
        }
        return answer;
    }
    
    public int change(char c){
        if (c == 'U'){
            return 0;
        }
        if (c == 'D'){
            return 1;
        }
        if (c == 'R'){
            return 2;
        }
        if (c == 'L'){
            return 3;
        }
        return 0;
    }
}