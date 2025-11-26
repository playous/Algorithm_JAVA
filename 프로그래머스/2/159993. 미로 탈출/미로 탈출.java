import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static int R, C;
    static class Node {
        int r;
        int c;
        int level;
        Node(int r, int c, int level){
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];
        visited = new boolean[R][C];
        
        int RR = 0, RC = 0, SR = 0, SC = 0, ER = 0, EC = 0;
        for (int i = 0; i < R ; i ++){
            for (int j = 0; j < C ; j++){
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'L'){
                    RR = i;
                    RC = j;
                }
                if (map[i][j] == 'S'){
                    SR = i;
                    SC = j;
                }
                if (map[i][j] == 'E'){
                    ER = i;
                    EC = j;
                }
            }
        }
        int answer = 0;
        int cnt1 = dfs(SR, SC, RR, RC);
        visited = new boolean[R][C];
        int cnt2 = dfs(RR, RC, ER, EC);
        if (cnt1 == 0 || cnt2 == 0) answer = -1;
        else answer = cnt1 + cnt2;
        
        return answer;
    }
    
    static int dfs(int sr, int sc, int gr, int gc){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(sr,sc,0));
        visited[sr][sc] = true;
        int cnt = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int level = cur.level;
            if (r == gr && c == gc){
                cnt = level;
                break;
            }
            for (int i = 0 ; i < 4 ; i ++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C){
                    if (!visited[nr][nc] && map[nr][nc] != 'X'){
                        q.add(new Node(nr, nc , level + 1));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return cnt;
    }
}