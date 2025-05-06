import java.util.*;

class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int[][] map; 
    static int sum;
    static int len_x; 
    static int len_y;
    
    public int[] solution(String[] maps) {
        len_x = maps[0].length();
        len_y = maps.length;
        
        visited = new boolean[len_y][len_x];
        map = new int[len_y][len_x];
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0 ; i < len_y ; i++){
            for (int j = 0 ; j < len_x ; j++){
                char ch = maps[i].charAt(j);
                map[i][j] = ch == 'X' ? 0 : ch- '0';
            }
        }
        
        for (int i = 0 ; i < len_y ; i++){
            for (int j = 0 ; j < len_x ; j++){
                if (map[i][j] != 0 && !visited[i][j]){
                    sum = 0;
                    dfs(i,j);
                    list.add(sum);
                }
                else visited[i][j] = true;
            }
        }
        if (list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for (int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void dfs(int x , int y){
        visited[x][y] = true;
        sum += map[x][y];
        for (int i = 0 ; i < 4 ; i++){
            int a = x + dy[i];
            int b = y + dx[i];
            if (a >= 0 && a < len_y && b >= 0 && b < len_x){
                if(map[a][b] != 0 && !visited[a][b]){
                    dfs(a,b);
                }
            }
        }
        
    }
}