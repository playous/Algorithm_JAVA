import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static int[][] cMap;
    static int count, R, C;
    
    static class Node {
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        int answer = 0;
        
        visited = new boolean[R][C];
        map = new int[R][C];
        cMap = new int[R][C];
        
        for (int i = 0 ; i < R; i ++){
            for (int j = 0 ; j < C ; j ++){
                map[i][j] = land[i][j];    
            }
        }
        
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int flag = 1;
        for (int i = 0 ; i < R; i ++){
            for (int j = 0 ; j < C ; j ++){
                if (map[i][j] == 1){
                    if (!visited[i][j]){
                        count = bfs(i,j,flag);
                        hashMap.put(flag, count);
                        flag++;
                    }
                }
            }
        }
        
        for (int j = 0 ; j < C ; j ++){
            int c1 = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0 ; i < R ; i++){
                if (cMap[i][j] != 0){
                    if (!set.contains(cMap[i][j])){
                        set.add(cMap[i][j]);
                        c1 += hashMap.get(cMap[i][j]);
                    }
                    
                }
            }
            answer = Math.max(answer, c1);
        }
        
        return answer;
    }
    
    static int bfs(int r, int c, int flag){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(r, c));
        visited[r][c] = true;
        int cnt = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            cMap[cr][cc] = flag;
            cnt++;
            for (int i = 0 ; i < 4 ; i ++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C){
                    if (!visited[nr][nc] && map[nr][nc] == 1) {
                        q.add(new Node(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return cnt;
        
    }
}