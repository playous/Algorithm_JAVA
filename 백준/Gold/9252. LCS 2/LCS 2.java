import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int r;
        int c;
        int level;
        Node(int r, int c, int level) {
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean[][] visited;
    static int[][] dp;
    static int n, m;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        n = arr1.length;
        m = arr2.length;

        visited = new boolean[n + 1][m + 1];

        dp = new int[n + 1][m + 1];

        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= n ; i ++){
            char cur = arr1[i - 1];
            for (int j = 1; j <= m ; j ++){
                char next = arr2[j - 1];
                if (cur == next) {
                    dp[i][j] = dp[i -1][j - 1] + 1;
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int target = dp[n][m];

        int r = n;
        int c = m;

        while(target > 0){
            int[] last =  bfs(r, c, target);
            answer.append(arr1[last[0] - 1]);
            r = last[0] - 1;
            c = last[1] - 1;
            target--;
        }

        if(dp[n][m] == 0) System.out.print(0);
        else {
            System.out.println(dp[n][m]);
            System.out.print(answer.reverse().toString());
        }

    }

    public static int[] bfs(int r, int c, int target){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(r, c, 1));
        visited[r][c] = true;

        int[] max = new int[2];

        int maxLevel = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int curLevel = cur.level;

            if(curLevel > maxLevel) {
                maxLevel = curLevel;
                max[0] = cur.r;
                max[1] = cur.c;
            }

            for (int i = 0 ; i < 4 ; i ++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= 1 && nc >= 1 && nr <= r && nc <= c ){
                    if (dp[nr][nc] == target && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new Node(nr, nc, curLevel + 1));
                    }
                }
            }

        }

        return max;
    }
}
