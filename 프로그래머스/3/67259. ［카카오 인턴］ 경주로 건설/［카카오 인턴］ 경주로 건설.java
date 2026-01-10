import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] visited;
    static int n;
    static int answer;
    
    static class node{
        int r;
        int c;
        int dic; // 방향 (0~3) (어디서 왔는지)
        int cost;
        node(int r, int c, int dic, int cost){
            this.r = r;
            this.c = c;
            this.dic = dic;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        answer = 0;
        n = board.length;
        visited = new int[n][n];
        
        for (int i = 0 ; i < n ; i ++){
            for (int j = 0 ; j < n ; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        
        bfs(board);
        
        return answer;
    }
    
    private static void bfs(int[][] board){
        PriorityQueue<node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        
        pq.add(new node(0,0,4,0)); // 시작점 4 -> 무조건 직진
        visited[0][0] = 0;
        
        while(!pq.isEmpty()){
            node cur = pq.poll();
            int r = cur.r;
            int c = cur.c;
            int prevDic = cur.dic;
            int cost = cur.cost;
            
            if (r == n - 1 && c == n - 1){
                answer = cost;
                return;
            }
            
            for (int i = 0 ; i < 4 ; i ++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                int dic = i;
                int nCost = cost + 100;
                if (prevDic != dic && prevDic != 4) nCost += 500;
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if (nCost - 399 <= visited[nr][nc] && board[nr][nc] == 0){ 
                        pq.add(new node(nr,nc,dic,nCost));
                        visited[nr][nc] = nCost;
                    }
                }
            }
        }
    }
}