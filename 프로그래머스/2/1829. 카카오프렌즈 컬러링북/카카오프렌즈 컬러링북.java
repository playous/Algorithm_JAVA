import java.util.*;

       
class Data{
    int x;
    int y;
    public Data(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        
        int count = 0;
        int maxArea = 0;
        
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    count++;
                    maxArea = Math.max(maxArea,bfs(i,j,picture,picture[i][j]));
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = maxArea;
        return answer;
    }
    
    int bfs(int a, int b, int[][] picture, int value){
        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(a,b));
        visited[a][b] = true;
        int count = 0;
        
        while (!q.isEmpty()){
            count++;
            Data d = q.poll();
            for (int i = 0 ; i < 4; i ++){
                int x = d.x + dx[i];
                int y = d.y + dy[i];
                if (x < picture.length && y < picture[0].length && x >= 0 && y >= 0){
                    if (picture[x][y] == value && !visited[x][y]){
                        q.offer(new Data(x,y));
                        visited[x][y] = true;
                    }
                }
            }
        }
        
        return count;
    }
    
}