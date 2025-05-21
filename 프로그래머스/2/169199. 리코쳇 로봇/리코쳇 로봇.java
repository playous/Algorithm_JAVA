import java.util.*;

class Solution {
    class Data {
        int x; 
        int y;
        int count;
        
        public Data(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    boolean[][] visited;
    char[][] table;
    
    int sx,sy,gx,gy;
    
    int rows, colums;
    
    public int solution(String[] board) {
        colums = board[0].length();
        rows = board.length;
        
        visited = new boolean[rows][colums];
        table = new char[rows][colums];
        
        sx = 0;
        sy = 0;
        gx = 0;
        gy = 0;
        
        int idx = 0;
        
        for (String s : board){
            if (s.contains("R")) {
                sx = idx;
                sy = s.indexOf("R");
            }
            if (s.contains("G")) {
                gx = idx;
                gy = s.indexOf("G");
            }
            table[idx++] = s.toCharArray();
        }
        
        visited[sx][sy] = true;
        
        int answer = bfs();
        
        return answer;
    }
    
    int bfs(){
        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(sx,sy,0));
        
        while(!q.isEmpty()){
            Data d = q.poll();
            int x = d.x;
            int y = d.y;
            int count = d.count;
            
            if (x == gx && y == gy) return count;
            
            for (int i = 0 ; i < 4 ; i ++){
                int nx = x;
                int ny = y;
                
                while(true){
                    nx += dx[i];
                    ny += dy[i];
                    
                    if (nx < 0 || nx >= rows || ny < 0 || ny >= colums || table[nx][ny] == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if (!visited[nx][ny]){
                    q.offer(new Data(nx,ny,count + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}