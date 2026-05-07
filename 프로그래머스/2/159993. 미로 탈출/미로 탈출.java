import java.util.*;
import java.io.*;

class Solution {
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int R, C;
    
    char[][] map;
    boolean[][] visited;
    
    int answer;
    
    class Node{
        int r;
        int c;
        int time;
        Node(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
                
        answer = -1;
        map = new char[R][C];
        
        for (int i = 0 ; i < R ; i ++){
            map[i] = maps[i].toCharArray();
        }
        
        int sr = 0;
        int sc = 0;
        int lr = 0;
        int lc = 0;
        int er = 0;
        int ec = 0;
        
        for (int i = 0 ; i < R ; i ++){
            for (int j = 0 ; j < C ; j ++){
                if(map[i][j] == 'S'){
                    sr = i;
                    sc = j;
                }
                if(map[i][j] == 'L'){
                    lr = i;
                    lc = j;
                }
                if(map[i][j] == 'E'){
                    er = i;
                    ec = j;
                }
                
            }
        }
        
        int time1 = dfs(sr, sc, lr, lc, 'L');
        int time2 = dfs(lr, lc, er, ec, 'E');
                
        int answer = time1 + time2;
        if (time1 == 0 || time2 == 0) answer = -1;
        return answer;
    }
    
    public int dfs(int startR, int startC, int goalR, int goalC, char goal){
        visited = new boolean[R][C];
        Queue<Node> q = new ArrayDeque<>();
        
        q.add(new Node(startR, startC, 0));
        visited[startR][startC] = true;
        
        int answerTime = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            int ct = cur.time;
            
            if (cr == goalR && cc == goalC){
                answerTime = ct;
                break;
            }
            
            for (int i = 0 ; i < 4; i ++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                    if (!visited[nr][nc] && (map[nr][nc] != 'X' || map[nr][nc] == goal)){
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc, ct + 1));
                    }
                }
            }
        }
        return answerTime;
        
    }
}