import java.util.*;
import java.io.*;

class Solution{
    
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int count;
    
    static class Node {
        int r;
        int c;
        Node (int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            List<Node>[] list = new List[9];
            count = 0;
            int answer = 0;
            
            for (int i = 0; i <= 8 ; i ++){
                list[i] = new ArrayList<>();
            }
            
            for (int i = 0 ; i < n ; i ++){
                char[] arr = br.readLine().toCharArray();
                for (int j = 0; j < n; j++){
                    if (arr[j] == '*') {
                        calc(i,j);
                        visited[i][j] = true;
                        count++;
                    }
                }
            }
            
            for (int i = 0 ; i < n ; i ++){
                for (int j = 0 ; j < n ; j++){
                    if (!visited[i][j]){
                        list[map[i][j]].add(new Node(i,j));
                    }
                }
            }
            
            for (Node node : list[0]){
                 if (!visited[node.r][node.c]){
                     answer++;
                     bfs(node.r, node.c);
                     if (count == n*n) break;
                }
            }
            
            if (count < n * n) answer += (n * n) - count;
            
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
	}
    
    static void calc (int r, int c){
        for (int i = 0 ; i < 8 ; i ++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nr < n && nc >=0 && nc < n){
                map[nr][nc]++;
            }
        }
    }
    
    static void bfs(int r, int c){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(r, c));
        visited[r][c] = true;
        count++;
        
        while (!q.isEmpty()){
            Node cur = q.poll();
            for (int i = 0 ; i < 8; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if (!visited[nr][nc]){
                        visited[nr][nc] = true;
                        count++;
                        if (map[nr][nc] == 0) q.add(new Node(nr, nc));
                    }
                }
            }
        }
    }     
}