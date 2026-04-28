import java.util.*;

class Solution {    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    
    class Node{
        int r;
        int c;
        int cost;
        int flag;
        Node(int r, int c, int cost, int flag){
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.flag = flag;
        }
    }
    
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][] visited = new int[n][n];
        
        for (int i = 0 ; i < n ; i ++){
            for (int j = 0; j < n ; j ++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        
        if (board[0][1] == 0) {
            q.add(new Node(0, 1, 100, 2));
            visited[0][1] = 100;
        }
        if (board[1][0] == 0) {
            q.add(new Node(1, 0, 100, 1));
            visited[1][0] = 100;
        }
        
        /*
            위 = 0
            아래 = 1
            오른쪽 = 2
            왼쪽 = 3
        */
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int cr = cur.r;
            int cc = cur.c;
            int cost = cur.cost;
            int flag = cur.flag;
            
             if (cr == n-1 && cc == n-1) return cost;
            
            for (int i = 0 ; i < 4 ; i ++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int nCost = cost + 100;
                if (i != flag) nCost += 500;
                if (nr >= 0 && nc >= 0 && nr < n && nc < n){
                    if (board[nr][nc] == 0 && nCost - 399 <= visited[nr][nc]){
                        visited[nr][nc] = nCost;
                        q.add(new Node(nr, nc, nCost, i));
                    }
                }
            }
        }
        
        return visited[n-1][n-1];
    }
}