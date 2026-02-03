import java.util.*;

class Solution {
    static String[][] map;
    static char[][] cMap;
    
    static int[] dr = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public int[] solution(String[][] places) {
        this.map = places;
        int[] answer = new int[5];
        
        for (int i = 0; i < 5 ; i ++){
            answer[i] = calc(i) ? 1 : 0;
        }
        return answer;
    }
    
    public static boolean calc(int idx){
        cMap = new char[5][5];
        for (int i = 0 ; i < 5 ; i ++){
            cMap[i] = map[idx][i].toCharArray();
        }
        
        for (int i = 0; i < 5 ; i ++){
            for (int j = 0; j < 5; j ++){
                if (cMap[i][j] == 'P')
                    if (!calc1(i, j)) {
                        return false;
                    }
            }
        }
        return true;
    }
    
    public static boolean calc1(int r, int c){
        for (int i = 0; i < 4 ; i ++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5){
                if(cMap[nr][nc] == 'P') return false;
            }
        }
        
        for (int i = 4; i < 8 ; i ++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5){
                if(cMap[nr][nc] == 'P') {
                    if(dr[i] == -1 && dc[i] == -1){
                        if(cMap[nr+1][nc] != 'X' || cMap[nr][nc+1] != 'X') return false;
                    }
                    if(dr[i] == -1 && dc[i] == 1){
                        if(cMap[nr][nc-1] != 'X' || cMap[nr+1][nc] != 'X') return false;
                    }
                    if(dr[i] == 1 && dc[i] == -1){
                        if(cMap[nr][nc+1] != 'X' || cMap[nr-1][nc] != 'X') return false;
                    }
                    if(dr[i] == 1 && dc[i] == 1){
                        if(cMap[nr-1][nc] != 'X' || cMap[nr][nc-1] != 'X') return false;
                    }
                }
            }
        }
        
        for (int i = 0; i < 4 ; i ++){
            int nr = r + 2 * dr[i];
            int nc = c + 2 * dc[i];
            if (nr >= 0 && nc >= 0 && nr < 5 && nc < 5){
                if(cMap[nr][nc] == 'P') {
                    if(cMap[nr - dr[i]][nc - dc[i]] != 'X') return false;
                }
            }
        }
        return true;
    }
}