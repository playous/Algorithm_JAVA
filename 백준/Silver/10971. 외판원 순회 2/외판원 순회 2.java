import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            backTrack(i,i,visited,0,0);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void backTrack(int start, int cur, boolean[] visited, int cost , int count){
        if (cost >= answer){
            return;
        }
        if (count == n - 1){
            if (map[cur][start] == 0) return;
            cost += map[cur][start];
            answer = Math.min(answer, cost);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && map[cur][i] != 0){
                visited[i] = true;
                backTrack(start, i,visited,cost+map[cur][i],count + 1);
                visited[i] = false;
            }
        }
    }
}

